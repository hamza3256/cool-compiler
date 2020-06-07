import ast.*;
import ast.visitor.BaseVisitor;
import java.io.PrintStream;
import java.util.List;

import java.util.AbstractMap;


public class ScopeCheckingVisitor extends BaseVisitor<Object, Object> {
    public ScopeCheckingVisitor() {}

    private Symbol fName;

    public Object visit(ProgramNode node, Object data) {

        Semant.symtable.enterScope();

        super.visit(node, data);

        if (Semant.symtable.lookup(TreeConstants.Main) == null) {
            displaySemErr("Class Main is not defined.");
        }
        return null;
    }


    public Object visit(ClassNode node, Object data) {

        fName = node.getFilename();

        AbstractMap.SimpleImmutableEntry infP = new AbstractMap.SimpleImmutableEntry<Symbol, TreeNode>(node.getParent(), node);

        Semant.symtable.enterScope();

        if (Semant.symtable.lookup(node.getName()) != null) {
            displaySemErr(node, "Class " + node.getName().getName() + " was previously defined.");
        } else {
            Semant.symtable.addId(node.getName(), infP);
        }

        super.visit(node, node);

        return null;
    }

    public Object visit(MethodNode node, Object data) {

        Semant.symtable.enterScope();

        ClassNode crClass = (ClassNode) data;

        if (Semant.symtable.lookup(node.getName()) != null) {

            ClassNode methodOvCls = (ClassNode) ((AbstractMap.SimpleImmutableEntry)Semant.symtable.lookup(node.getName())).getValue();

            if (crClass != methodOvCls) {

                if (crClass.getParent() == methodOvCls.getName()) {

                    List<FormalNode> formals = node.getFormals();
                    List<FeatureNode> features = methodOvCls.getFeatures();

                    boolean ck = false;
                    for (FeatureNode f : features) {
                        if  (f instanceof MethodNode) {
                            if (node.getName() == ((MethodNode) f).getName()) {
                                List<FormalNode> crFormal = ((MethodNode) f).getFormals();
                                if (formals.size() != crFormal.size()) {
                                    displaySemErr(node,
                                            "Incompatible number of formal parameters in redefined method " + node.getName().getName() + ".");
                                } else {
                                    int index = 0;
                                    for (FormalNode fr : formals) {

                                        if (fr.getType_decl() != crFormal.get(index).getType_decl()) {
                                            displaySemErr(node,
                                                    "In redefined method " + node.getName().getName() + ", parameter type " +
                                                            fr.getType_decl().getName() +
                                                            " is different from original type " + crFormal.get(index).getType_decl().getName() +"");
                                        } else {
                                            ck = true;
                                        }
                                        index++;
                                    }
                                }
                            }
                        }
                    }
                    if (ck) {
                        Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getReturn_type(), data));
                    }
                }
            }
        } else {
            Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getReturn_type(), data));
        }

        super.visit(node, node);

        return null;
    }



    public Object visit(AttributeNode node, Object data) {

        AbstractMap.SimpleImmutableEntry infoAtt = (AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName());

        if (node.getName() != TreeConstants.self) {

            if (Semant.symtable.probe(node.getName()) == null) {

                if (Semant.symtable.lookup(node.getName()) == null) {
                    Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getType_decl(), (ClassNode) data));

                } else {

                    Symbol currClsPr = ((ClassNode) data).getParent();
                    Symbol fndClsNm = ((ClassNode) infoAtt.getValue()).getName();

                    if (currClsPr == fndClsNm) {
                        displaySemErr(node, "Attribute " + node.getName().getName() + " is an attribute of an inherited class.");
                    } else {
                        Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getType_decl(), (ClassNode) data));
                    }
                }

            } else {
                displaySemErr("Attribute " + node.getName().getName() + " has been defined in this scope.");
            }

        } else {
            displaySemErr(node, "'self' cannot be the name of an attribute.");
        }

        super.visit(node, data);


        return null;
    }

      public Object visit(ObjectNode node, Object data) {

        if (Semant.symtable.lookup(node.getName()) != null) {

            if (data instanceof ClassNode) {

                Symbol crClass =  ((ClassNode) data).getName();
                Symbol fndClass = ((ClassNode)((AbstractMap.SimpleImmutableEntry) Semant.symtable.lookup(node.getName())).getValue()).getName();

                if (crClass != fndClass) {
                    Symbol currPrCls = ((ClassNode) data).getParent();

                    if (currPrCls != fndClass) {
                        displaySemErr(node, "Undeclared identifier " + node.getName().getName() + ".");
                    }
                }
            }

        } else if (Semant.symtable.lookup(node.getName()) == null) {
            if (data instanceof MethodNode) {
                if (node.getName() != TreeConstants.self) {
                    displaySemErr(node, "Undeclared identifier " + node.getName().getName() + ".");
                }
            }
        }

        super.visit(node, data);

        return null;
    }

    public Object visit(LetNode node, Object data) {

        Semant.symtable.enterScope();
        if (node.getIdentifier() == TreeConstants.self){
            displaySemErr(node, "'self' cannot be bound in a 'let' expression.");

        } else {
            Semant.symtable.addId(node.getIdentifier(), new AbstractMap.SimpleImmutableEntry<>(node.getType_decl(), data));
        }

        super.visit(node, node);
        Semant.symtable.exitScope();
        return null;
    }



    public Object visit(BranchNode node, Object data) {

        if (Semant.symtable.probe(node.getType_decl()) != null) {
            if (data instanceof CaseNode) {
                displaySemErr(node, "Duplicate branch " + node.getType_decl().getName() + " in case statement.");
            }

        } else {
            if (node.getType_decl() != null) {
                Semant.symtable.addId(node.getType_decl(), new AbstractMap.SimpleImmutableEntry<>(node.getName(), data));
            }
        }

        super.visit(node, data);

        return null;
    }

    public Object visit(FormalNode node, Object data) {

        super.visit(node, data);

        if (Semant.symtable.probe(node.getName()) != null ) {
            displaySemErr(node, "Formal parameter " + node.getName().getName() +" is multiply defined.");
        }

        Semant.symtable.addId(node.getName(), new AbstractMap.SimpleImmutableEntry<>(node.getType_decl(), (MethodNode) data));

        return null;
    }


    public Object visit(LoopNode node, Object data) {

        Semant.symtable.enterScope();

        super.visit(node, data);

        return null;
    }

    public Object visit(BlockNode node, Object data) {

        Semant.symtable.enterScope();

        super.visit(node, data);

        Semant.symtable.exitScope();

        return null;
    }

    public Object visit(CaseNode node, Object data) {
        Semant.symtable.enterScope();

        super.visit(node, node);

        Semant.symtable.exitScope();
        return null;
    }


    public void displaySemErr(TreeNode node, String msg) {
        PrintStream ps = Utilities.semantError(fName, node);
        ps.println(msg);
    }

    public void displaySemErr(String msg) {
        PrintStream ps = Utilities.semantError();
        ps.println(msg);
    }
}
