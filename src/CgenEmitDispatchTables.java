import ast.Symbol;

class CgenEmitDispatchTables extends CgenVisitor {

    // Emit the dispatch table of a class
    @Override
    Void visit(CgenNode v) {
	Cgen.emitter.emitDispTableRef(v.getClassNode().getName());
	super.visit(v);
        return null;
    }
}
