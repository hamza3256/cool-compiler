import ast.ClassNode;
import ast.ProgramNode;
import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ASTBuilder extends CoolParserBaseVisitor<Tree> {

    @Override
    public Tree visitProgram(CoolParser.ProgramContext ctx) {

        ProgramNode p = new ProgramNode(ctx.getStart().getLine());
        for (CoolParser.CoolClassContext c:ctx.coolClass()) {
            p.add((ClassNode)visitCoolClass(c));
        }
        return p;
    }

    public Symbol visitTermNode(TerminalNode tNode){
        return new Symbol(tNode.getText(),tNode.getSymbol().getLine());
    }

    @Override
    public Tree visitCoolClass(CoolParser.CoolClassContext classctx){

        Symbol name = visitTermNode(classctx.TYPEID(0));
        Symbol inherits = new Symbol("Object",0);
        if(classctx.TYPEID().size()>1)
        inherits = visitTermNode(classctx.TYPEID(1));
        Symbol fileName = new Symbol(classctx.fileName,0);
        ClassNode c = new ClassNode(classctx.getStart().getLine(),name,inherits,fileName);
        for(CoolParser.FeatureContext feature : classctx.feature()){
            c.add((FeatureNode)feature.accept(this));
        }
        return c;
    }

    @Override
    public Tree visitAttribute(CoolParser.AttributeContext attributeContext){
        ExpressionNode exprNode = new NoExpressionNode(attributeContext.getStart().getLine());
        if(attributeContext.expression()!= null)
            exprNode = (ExpressionNode) attributeContext.expression().accept(this);
        Symbol name = visitTermNode(attributeContext.OBJECTID());
        Symbol type = visitTermNode(attributeContext.TYPEID());
        AttributeNode node = new AttributeNode(attributeContext.getStart().getLine(),name,type,exprNode);
        return node;
    }


    @Override
    public Tree visitMethod(CoolParser.MethodContext methodContext){

        ExpressionNode exprNode = (ExpressionNode)methodContext.expression().accept(this);
        Symbol name =visitTermNode(methodContext.OBJECTID());
        Symbol type = visitTermNode(methodContext.TYPEID());
        ArrayList<FormalNode> formalNodes = new ArrayList<FormalNode>();
        for(CoolParser.FormalContext formal : methodContext.formal()){
            formalNodes.add((FormalNode) formal.accept(this));
        }
        MethodNode node = new MethodNode(methodContext.getStart().getLine(),name,formalNodes,type,exprNode);
        return node;
    }

    @Override
    public Tree visitFormal(CoolParser.FormalContext formalContext){
        Symbol name = visitTermNode(formalContext.OBJECTID());
        Symbol type = visitTermNode(formalContext.TYPEID());
        return new FormalNode(formalContext.getStart().getLine(),name,type);
    }

    @Override public Tree visitParen_expr(CoolParser.Paren_exprContext ctx) {
      return  ctx.expression().accept(this);
    }

    @Override
    public Tree visitNew(CoolParser.NewContext ctx)
    {
        return new NewNode(ctx.getStart().getLine(),visitTermNode(ctx.TYPEID()));
    }

    @Override
    public Tree visitPlusminus(CoolParser.PlusminusContext ctx){
        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1 = (ExpressionNode) ctx.expression(1).accept(this);

        if(ctx.MINUS_OP()==null)
            return new PlusNode(ctx.getStart().getLine(),expression_0,expression_1);
        return  new SubNode(ctx.getStart().getLine(),expression_0,expression_1);
    }

    @Override
    public Tree visitDispatch(CoolParser.DispatchContext ctx)  {
        List<ExpressionNode> actuals = new ArrayList<>();
        ExpressionNode expression = (ExpressionNode) ctx.expression(0).accept(this);

        for(int i=1;i<ctx.expression().size();i++){
            actuals.add((ExpressionNode)ctx.expression(i).accept(this));
        }
        return new DispatchNode(ctx.getStart().getLine(),expression,visitTermNode(ctx.OBJECTID()),actuals);
    }

    @Override
    public Tree visitBool(CoolParser.BoolContext ctx) {
       BoolConstNode node = new BoolConstNode(ctx.getStart().getLine(),Boolean.parseBoolean(ctx.BOOL_CONST().getText()));
        return node;
    }

    @Override
    public IsVoidNode visitIsvoid(CoolParser.IsvoidContext ctx){
        ExpressionNode expression = (ExpressionNode) ctx.expression().accept(this);
        return new IsVoidNode(ctx.getStart().getLine(),expression);
    }

    @Override
    public Tree visitSelfdispatch(CoolParser.SelfdispatchContext ctx) {
        List<ExpressionNode> actuals = new ArrayList<>();
        ExpressionNode expression =  new ObjectNode(ctx.getStart().getLine(),new Symbol("self",ctx.getStart().getLine()));
        for(int i=0;i<ctx.expression().size();i++){
            actuals.add((ExpressionNode)ctx.expression(i).accept(this));
        }
        return new DispatchNode(ctx.getStart().getLine(),expression,visitTermNode(ctx.OBJECTID()),actuals);
    }

    @Override
    public Tree visitStaticdispatch(CoolParser.StaticdispatchContext ctx) {
        List<ExpressionNode> actuals = new ArrayList<>();
        ExpressionNode expression = (ExpressionNode) ctx.expression(0).accept(this);
        for(int i=1;i<ctx.expression().size();i++){
            actuals.add((ExpressionNode)ctx.expression(i).accept(this));
        }
        return new StaticDispatchNode(ctx.getStart().getLine(),expression,visitTermNode(ctx.TYPEID()),visitTermNode(ctx.OBJECTID()),actuals);
    }

    @Override public Tree visitInt_complement(CoolParser.Int_complementContext ctx) {
        return new NegNode(ctx.getStart().getLine(),(ExpressionNode)ctx.expression().accept(this));
    }

    public LTNode  visitLess(CoolParser.LessContext ctx){
        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1= (ExpressionNode) ctx.expression(1).accept(this);

        return new LTNode(ctx.getStart().getLine(),expression_0,expression_1);
    }


    @Override
    public EqNode visitEq(CoolParser.EqContext ctx){
        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1= (ExpressionNode) ctx.expression(1).accept(this);

        return new EqNode(ctx.getStart().getLine(),expression_0,expression_1);
    }

    @Override
    public Tree visitInt(CoolParser.IntContext ctx) {
        IntConstNode node = new IntConstNode(ctx.getStart().getLine(),visitTermNode(ctx.INT()));
        return node;
    }


    @Override
    public Tree visitOBJECTID(CoolParser.OBJECTIDContext ctx){
        return new ObjectNode(ctx.getStart().getLine(),visitTermNode(ctx.OBJECTID()));
    }

    @Override
    public Tree visitStr(CoolParser.StrContext ctx) {
        StringConstNode node = new StringConstNode(ctx.getStart().getLine(),visitTermNode(ctx.STR_CONST()));
        return node;
    }

    @Override
    public LetNode visitLetInit(CoolParser.LetInitContext ctx){
        ExpressionNode body = (ExpressionNode) ctx.expression(1).accept(this);
        Symbol type = visitTermNode(ctx.TYPEID());
        Symbol id = visitTermNode(ctx.OBJECTID());
        ExpressionNode init =(ExpressionNode) ctx.expression(0).accept(this);

        return new LetNode(ctx.getStart().getLine(),id,type,init,body);
    }

    @Override
    public LoopNode visitLoop(CoolParser.LoopContext ctx){

        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1= (ExpressionNode) ctx.expression(1).accept(this);

        return new LoopNode(ctx.getStart().getLine(),expression_0,expression_1);
    }


    @Override
    public LEqNode visitLess_eq(CoolParser.Less_eqContext ctx){
        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1= (ExpressionNode) ctx.expression(1).accept(this);

        return new LEqNode(ctx.getStart().getLine(),expression_0,expression_1);
    }

    @Override
    public Tree visitMultdiv(CoolParser.MultdivContext ctx){

        ExpressionNode expression_0 = (ExpressionNode) ctx.expression(0).accept(this);
        ExpressionNode expression_1= (ExpressionNode) ctx.expression(1).accept(this);

        if(ctx.MULT_OP() == null)
            return new DivideNode(ctx.getStart().getLine(),expression_0,expression_1);

        return new MulNode(ctx.getStart().getLine(),expression_0,expression_1);
    }

    @Override public Tree visitBool_complement(CoolParser.Bool_complementContext ctx){
        CompNode node = new CompNode(ctx.getStart().getLine(),(ExpressionNode)ctx.expression().accept(this));
        return node;
    }


    @Override
    public BlockNode visitBlock(CoolParser.BlockContext ctx) {
        ArrayList<ExpressionNode> expressions = new ArrayList<>();
        for(CoolParser.ExpressionContext expression : ctx.expression()){
            expressions.add((ExpressionNode) expression.accept(this));
        }
        return new BlockNode(ctx.getStart().getLine(),expressions);
    }

    @Override
    public LetNode visitLet(CoolParser.LetContext ctx){

        ExpressionNode body = (ExpressionNode) ctx.expression().accept(this);
        Symbol type = visitTermNode(ctx.TYPEID());
        Symbol id = visitTermNode(ctx.OBJECTID());
        ExpressionNode init = new  NoExpressionNode(ctx.getStart().getLine());

        return new LetNode(ctx.getStart().getLine(),id,type,init,body);
    }

    @Override
    public Tree visitIf(CoolParser.IfContext ctx) {
        return new CondNode(ctx.getStart().getLine(),(ExpressionNode)ctx.expression(0).accept(this),(ExpressionNode)ctx.expression(1).accept(this),(ExpressionNode)ctx.expression(2).accept(this));
    }

    @Override
    public Tree visitCase(CoolParser.CaseContext ctx) {
        ExpressionNode exprNode = (ExpressionNode)ctx.expression(0).accept(this);

        List<BranchNode> branches = new ArrayList<BranchNode>();
        for(int i=1; i < ctx.expression().size();i++){
            BranchNode branch = new BranchNode(ctx.getStart().getLine(),visitTermNode(ctx.OBJECTID(i-1)),visitTermNode(ctx.TYPEID(i-1)),(ExpressionNode)ctx.expression(i).accept(this));
            branches.add(branch);
        }
        return new CaseNode(ctx.getStart().getLine(),exprNode,branches);
    }


    @Override
    public Tree visitAssign(CoolParser.AssignContext ctx) {
        ExpressionNode exprNode = (ExpressionNode)ctx.expression().accept(this);
        return new AssignNode(ctx.getStart().getLine(),visitTermNode(ctx.OBJECTID()),exprNode);
    }

}
