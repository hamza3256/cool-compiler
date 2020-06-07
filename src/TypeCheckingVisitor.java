import ast.visitor.BaseVisitor;
import ast.*;
import java.util.AbstractMap;

import java.io.PrintStream;
import java.util.List;

public class TypeCheckingVisitor extends BaseVisitor<Object, Object> {

    private Symbol fName;

    public Object visit(ClassNode node, Object data) {
        fName = node.getFilename();

        super.visit(node, node);
        return null;
    }

   
    public Object visit(MethodNode node, Object data) {

        if (Semant.symtable.lookup(node.getReturn_type()) == null && node.getReturn_type() != TreeConstants.SELF_TYPE) {
            displaySemErr(node, "Undefined return type " + node.getReturn_type().getName() + " in method " + node.getName().getName() + ".");

            super.visit(node, data);

        } else {

            super.visit(node, data);

            if (Semant.symtable.lookup(node.getName()) != null && node.getReturn_type() != TreeConstants.Object_) {

                if (node.getExpr().getType() != node.getReturn_type()) {

                    ClassNode crClass = (ClassNode) data;

                    if (node.getExpr().getType() == TreeConstants.SELF_TYPE) {

                        if (crClass.getName() != node.getReturn_type()) {

                            if (crClass.getParent() != node.getReturn_type()) {
                                displaySemErr(node,
                                        "Inferred return type " + node.getExpr().getType().getName() +
                                        " of method " + node.getName().getName() +
                                        " does not conform to declared return type " + node.getReturn_type().getName() + ".");
                            }
                        }

                    } else if (node.getExpr().getType() != null && node.getExpr().getType() != TreeConstants.Object_) {

                        if (node.getExpr().getType() == TreeConstants.No_type) {
                            displaySemErr(node,
                                    "Inferred return type " + TreeConstants.Object_.getName() +
                                    " of method " + node.getName().getName() +
                                    " does not conform to declared return type " + node.getReturn_type().getName() + ".");
                        } else {
                            displaySemErr(node,
                                    "Inferred return type " + node.getExpr().getType().getName() +
                                    " of method " + node.getName().getName() +
                                    " does not conform to declared return type " + node.getReturn_type().getName() + ".");
                        }
                    }
                }
            }
        }

        return null;
    }


    public Object visit(AttributeNode node, Object data) {
        super.visit(node, data);

        if (node.getInit().getType() != null)
            Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getInit().getType(), node));

        return null;
    }


    public Object visit(FormalNode node, Object data) {

        if (node.getName() == TreeConstants.self) {
            displaySemErr(node, "'self' cannot be the name of a formal parameter.");

        } else if (node.getType_decl() == TreeConstants.SELF_TYPE) {
            displaySemErr(node,
                    "Formal parameter " + node.getName().getName() +
                    " cannot have type " + node.getType_decl().getName() + ".");
        }

        super.visit(node, data);

        return null;
    }


    public Object visit(BranchNode node, Object data) {
        super.visit(node, data);

        if (node.getExpr() instanceof ObjectNode) {
            node.getExpr().setType(node.getType_decl());

        } else {

            ClassNode exprCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getExpr().getType())).getValue();

            if (exprCl.getParent() == node.getType_decl()) {
                node.getExpr().setType(exprCl.getName());

            } else {
                node.getExpr().setType(node.getType_decl());
            }
        }

        return null;
    }


    public Object visit(AssignNode node, Object data) {

        if (node.getName() == TreeConstants.self) {
            displaySemErr(node, "Cannot assign to 'self'.");
        }
        super.visit(node, data);

        if (Semant.symtable.lookup(node.getName()) != null ) {
            node.setType(node.getExpr().getType());

            if (((Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getKey()).getName().equals(node.getExpr().getType().getName())) {
                super.visit(node, data);
            } else {
                displaySemErr(node,
                        "Type " + node.getExpr().getType().getName() + " of assigned expression does not conform to declared type "
                                + ((Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getKey()).getName() + " of identifier "
                                + node.getName().getName() + ".");
            }
        }

        return null;
    }


    public Object visit(StaticDispatchNode node, Object data) {

        super.visit(node, data);

        Symbol exprType = node.getExpr().getType();

        if (exprType == TreeConstants.SELF_TYPE) {
            exprType = ((ClassNode) data).getName();
        }

        ClassNode typeCl     = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getType_name())).getValue();
        ClassNode exprCl     = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(exprType)).getValue();
        ClassNode disCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getValue();

        Symbol mType;

        if (typeCl == exprCl) {

            if (typeCl != disCl) {

                if (relationChecker(typeCl, disCl) == disCl.getName()) {

                    List<FeatureNode> features = disCl.getFeatures();
                    mType = exprType;

                    boolean flag = false;
                    for (FeatureNode f : features) {
                        if (f instanceof MethodNode) {

                            if (((MethodNode) f).getName() == node.getName()) {
                                flag = true;
                                mType = ((MethodNode) f).getReturn_type();

                            }
                        }
                    }

                    if (!flag) {
                        displaySemErr(node, "Dispatch to undefined method " + node.getName().getName() + ".");
                        node.setType(TreeConstants.No_type);
                    } else {
                        node.setType(mType);
                    }
                }

            } else {
                mType = (Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getKey();
                node.setType(mType);
            }

        } else {

            Symbol pClass = relationChecker(typeCl, exprCl);

            if (pClass != TreeConstants.Object_) {

                if (typeCl != disCl) {

                    List<FeatureNode> features = typeCl.getFeatures();
                    mType = exprType;

                    boolean flag = false;
                    for (FeatureNode f : features) {
                        if (f instanceof MethodNode) {

                            if (((MethodNode) f).getName() == node.getName()) {
                                flag = true;
                                mType = ((MethodNode) f).getReturn_type();
                            }
                        }
                    }

                    if (!flag) {
                        displaySemErr(node, "Dispatch to undefined method " + node.getName().getName() + ".");
                        node.setType(TreeConstants.No_type);
                    } else {
                        node.setType(mType);
                    }

                } else {
                    displaySemErr(node, "Expression type " + node.getExpr().getType().getName() + " does not conform to declared static dispatch type " + node.getType_name().getName() + ".");
                    node.setType(TreeConstants.No_type);
                }

            } else {
                displaySemErr(node, "Expression type " + node.getExpr().getType().getName() + " does not conform to declared static dispatch type " + node.getType_name().getName() + ".");
                node.setType(TreeConstants.No_type);
            }

        }

        return null;
    }


    public Object visit(DispatchNode node, Object data) {

        super.visit(node, data);

        if (Semant.symtable.lookup(node.getName()) != null) {

            Symbol mType = (Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getKey();
            Symbol mClass = ((ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getValue()).getName();
            Symbol exprType = node.getExpr().getType();


            if (mType != TreeConstants.SELF_TYPE) {

                if (exprType != TreeConstants.SELF_TYPE) {

                    if (mClass != exprType) {

                        if (Semant.symtable.lookup(exprType) != null) {

                            ClassNode clOfMethod = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getValue();
                            Symbol xPrType = (Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(exprType)).getKey();

                            if (mClass != xPrType) {

                                if (xPrType == clOfMethod.getParent()) {

                                    ClassNode classOfExprType = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(exprType)).getValue();
                                    List<FeatureNode> features = classOfExprType.getFeatures();

                                    boolean counter = false;
                                    for (FeatureNode f : features) {
                                        if (f instanceof MethodNode) {

                                            if (((MethodNode) f).getName() == node.getName()) {
                                                counter = true;
                                                mType = ((MethodNode) f).getReturn_type();
                                            }
                                        }
                                    }

                                    if (!counter) {
                                        displaySemErr(node, "Dispatch to undefined method " + node.getName().getName() + ".");
                                    }

                                } else {

                                    ClassNode mClsPar = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(clOfMethod.getParent())).getValue();
                                    List<FeatureNode> features = mClsPar.getFeatures();

                                    boolean counter = false;
                                    for (FeatureNode f : features) {
                                        if (f instanceof MethodNode) {

                                            if (node.getName() == ((MethodNode) f).getName()) {
                                                counter = true;
                                            }
                                        }
                                    }
                                    if (!counter) {
                                        displaySemErr(node, "Dispatch to undefined method " + node.getName().getName() + ".");
                                    }
                                }
                            }

                        } else {
                            displaySemErr(node, "Dispatch to undefined method " + node.getName().getName() + ".");
                        }
                    }
                }
                node.setType(mType);

            } else {
                node.setType(exprType);
            }

            List<FeatureNode> featureList = ((ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getValue()).getFeatures();

            for (FeatureNode feature : featureList) {

                if (feature instanceof MethodNode) {

                    List<FormalNode> formals = ((MethodNode) feature).getFormals();
                    List<ExpressionNode> actuals = node.getActuals();

                    if (node.getName() == ((MethodNode) feature).getName()) {
                        int index = 0;

                        for (ExpressionNode expr : actuals) {

                            if (expr.getType() != formals.get(index).getType_decl()) {

                                if (expr.getType() != TreeConstants.SELF_TYPE) {

                                    Symbol xPrType = ((ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(expr.getType())).getValue()).getParent();

                                    if (xPrType != formals.get(index).getType_decl()) {
                                        displaySemErr(node, "In call of method " + node.getName().getName() +
                                                ", type " + expr.getType().getName() + " of parameter " + formals.get(index).getName().getName() +
                                                " does not conform to declared type " + formals.get(index).getType_decl().getName() + ".");
                                    }

                                } else {
                                    Symbol parameterprType = ((ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(formals.get(index).getType_decl())).getValue()).getParent();

                                    if (parameterprType != TreeConstants.Object_) {
                                        displaySemErr(node, "In call of method " + node.getName().getName() +
                                                ", type " + expr.getType().getName() + " of parameter " + formals.get(index).getName().getName() +
                                                " does not conform to declared type " + formals.get(index).getType_decl().getName() + ".");
                                    }
                                }
                            }
                            index++;
                        }
                    }
                }
            }
        }

        return null;
    }

    public Object visit(CondNode node, Object data) {
        Semant.symtable.enterScope();

        super.visit(node, data);

        Symbol thenBrType = node.getThenExpr().getType();
        Symbol elseBrType = node.getElseExpr().getType();
        Symbol fnlType = thenBrType;

        boolean binary = true;
        if (thenBrType != null && elseBrType != null) { // could use this as a way to transverse the inheritance tree

            if (thenBrType == TreeConstants.SELF_TYPE) {
                thenBrType = ((ClassNode) data).getName();

            } else if (elseBrType == TreeConstants.SELF_TYPE) {
                elseBrType = ((ClassNode) data).getName();
            }

            ClassNode thenCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(thenBrType)).getValue();
            ClassNode elseCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(elseBrType)).getValue();

            boolean flag = true;
            while (flag) {
                if (thenBrType != elseBrType) {

                    if (thenCl.getName() == elseCl.getParent()) {
                        fnlType = thenCl.getName();
                        flag = false;
                    } else if (thenCl.getParent() == elseCl.getName()) {
                        fnlType = elseCl.getName();
                        flag = false;
                    } else if (thenCl.getParent() == elseCl.getParent()) {
                        fnlType = thenCl.getParent();
                        flag = false;
                    } else {
                        if (binary) {
                            thenCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(thenCl.getParent())).getValue();
                            binary = false;
                        } else {
                            elseCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(elseCl.getParent())).getValue();
                            binary = true;
                        }
                    }

                } else {
                    flag = false;
                }
            }
            node.setType(fnlType);

        } else {
            node.setType(TreeConstants.Object_);
        }

        Semant.symtable.exitScope();
        return null;
    }

    
    public Object visit(LoopNode node, Object data) {

        super.visit(node, data);

        if (node.getCond().getType() != TreeConstants.Bool) {
            displaySemErr(node, "Loop condition does not have type Bool.");
        }
        node.setType(TreeConstants.Object_);

        return null;
    }

    
    public Object visit(CaseNode node, Object data) {

        Semant.symtable.enterScope();

        super.visit(node, node);

        List<BranchNode> branches = node.getCases();

        Symbol crBrType = branches.get(0).getExpr().getType();
        Symbol fnlType = crBrType;

        for (int i = 1; i < branches.size() - 1; i++) {

            Symbol srchBrType = branches.get(i).getExpr().getType();

            if (crBrType != srchBrType) {

                ClassNode brCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(crBrType)).getValue();
                ClassNode schbrCl = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(srchBrType)).getValue();

                fnlType = relationChecker(brCl, schbrCl);
            }
        }

        node.setType(fnlType);

        Semant.symtable.exitScope();

        return null;
    }

   
    public Object visit(BlockNode node, Object data) {

        Semant.symtable.enterScope();

        super.visit(node, data);

        int index = node.getExprs().size() - 1;
        node.setType(node.getExprs().get(index).getType());

        Semant.symtable.exitScope();

        return null;
    }

    
    public Object visit(LetNode node, Object data) {

        Semant.symtable.enterScope();

        if (node.getIdentifier() != TreeConstants.self) {
            Semant.symtable.addId(node.getIdentifier(), new AbstractMap.SimpleImmutableEntry<>(node.getType_decl(), data));
        }

        super.visit(node, node);

        if (node.getType_decl() != node.getInit().getType()) {

            if (Semant.symtable.lookup(node.getInit().getType()) != null) {

                Symbol prType = (Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getInit().getType())).getKey();

                if (node.getType_decl() != prType) {

                    displaySemErr(node,
                            "Inferred type " + node.getInit().getType().getName() +
                            " of initialization of " + node.getIdentifier().getName() +
                            " does not conform to identifier's declared type " + node.getType_decl().getName() + ".");
                }
            }
        }

        node.setType(node.getBody().getType());

        Semant.symtable.exitScope();

        return null;
    }

    public Object visit(IntBinopNode node, Object data) {

        super.visit(node, data);

        if (!(node.getE1().getType() == TreeConstants.Int && node.getE2().getType() == TreeConstants.Int)) {
            displaySemErr(node, "non-Int arguments: " + node.getE1().getType().getName() + " + " + node.getE2().getType().getName());
        } else {
            node.setType(TreeConstants.Int);
        }

        return null;
    }

   
    public Object visit(BoolBinopNode node, Object data) {
        super.visit(node, data);

        if (node.getE1().getType() != node.getE2().getType()) {
            if (    node.getE1().getType() == TreeConstants.Bool ||
                    node.getE1().getType() == TreeConstants.Str  ||
                    node.getE1().getType() == TreeConstants.Int) {

                displaySemErr(node, "Illegal comparison with a basic type.");
            }
        }

        node.setType(TreeConstants.Bool);

        return null;
    }

    
    public Object visit(IntUnopNode node, Object data) {
        super.visit(node, data);
        node.setType(TreeConstants.Int);
        return null;
    }

   
    public Object visit(BoolUnopNode node, Object data) {
        super.visit(node, data);
        node.setType(TreeConstants.Bool);
        Semant.symtable.addId(node.getType(), new AbstractMap.SimpleImmutableEntry<>(TreeConstants.Bool, node));
        return null;
    }


    public Object visit(IntConstNode node, Object data) {

        node.setType(TreeConstants.Int);
        super.visit(node, data);
        return null;
    }

    
    public Object visit(BoolConstNode node, Object data) {
        node.setType(TreeConstants.Bool);
        super.visit(node, data);

        return null;
    }

    
    public Object visit(StringConstNode node, Object data) {

        node.setType(TreeConstants.Str);
        super.visit(node, data);
        return null;
    }

   
    public Object visit(NewNode node, Object data) {

        if (Semant.symtable.lookup(node.getType_name()) == null) {

            if (node.getType_name() != TreeConstants.SELF_TYPE) {
                displaySemErr(node, "'new' used with undefined class " + node.getType_name().getName() + ".");
            }
        }

        node.setType(node.getType_name());
        super.visit(node, data);
        return null;
    }

  
    public Object visit(IsVoidNode node, Object data) {
        super.visit(node, data);
        node.setType(TreeConstants.Bool);
        return null;
    }

  
    public Object visit(ObjectNode node, Object data) {
        super.visit(node, data);

        if (node.getName() == TreeConstants.self) {
            node.setType(TreeConstants.SELF_TYPE);
        } else {
            if (Semant.symtable.probe(node.getName()) != null) {

                node.setType((Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.probe(node.getName())).getKey());
            } else if (Semant.symtable.lookup(node.getName()) != null) {
                node.setType((Symbol) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getKey());
            } else {
                if (data instanceof CaseNode) {
                   
                } else {
                    displaySemErr(node, "Undeclared identifier " + node.getName().getName() + ".");
                }
            }
        }
        return null;
    }

    public void displaySemErr(TreeNode node, String msg) {
        PrintStream ps = Utilities.semantError(fName, node);
        ps.println(msg);
    }



    public Symbol relationChecker(ClassNode clA, ClassNode clB) {

        boolean flag = true;
        Symbol fnlType = clA.getName();
        ClassNode a = clA;
        ClassNode b = clB;

        while (flag) {

            if (a.getName() == clB.getName()) {
                fnlType = a.getName();
                flag = false;
            } else if (b.getName() == clA.getName()) {
                fnlType = b.getName();
                flag = false;
            } else if (a.getName() == clB.getParent()) {
                fnlType = a.getName();
                flag = false;
            } else if (b.getName() == clA.getParent()) {
                fnlType = b.getName();
                flag = false;
            } else if (a.getParent() != TreeConstants.Object_ && a.getParent() != TreeConstants.Object_) {

                a = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(a.getParent())).getValue();
                b = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(b.getParent())).getValue();

            } else if (a.getParent() != TreeConstants.Object_) {

                a = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(a.getParent())).getValue();

            } else if (b.getParent() != TreeConstants.Object_) {

                b = (ClassNode) ((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(b.getParent())).getValue();

            } else {

                fnlType = TreeConstants.Object_;
                flag = false;
            }

        }
        return fnlType;
    }
}