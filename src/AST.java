public interface AST {
    
    public static abstract class ExpressionA implements AST {
    }
    
    public static abstract class ExpressionA_Binaire extends ExpressionA {
        public ExpressionA gauche;
        public ExpressionA droite;
        
        protected ExpressionA_Binaire (ExpressionA gauche,ExpressionA droite) {
            this.gauche = gauche;
            this.droite = droite;
        }
        
        
        public abstract String symbole();
        
        public String toString() {
            return String.format("%3$s\n%1$s\n%2$s", gauche.toString(),symbole(),droite.toString());
        }
    }
    
    public static class Plus extends ExpressionA_Binaire {
        public Plus(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "AddiRe";};
    }
    
    public static class Moins extends ExpressionA_Binaire {
        public Moins(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "SubRe";};
    }
    
    
    public static class Mult extends ExpressionA_Binaire {
        public Mult(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "MultRe";};
    }
    
    public static class Div extends ExpressionA_Binaire {
        public Div(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "DiviRe";};
    }
    
    public static class Mod extends ExpressionA_Binaire {
        public Mod(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "ModiRe";};
    }
    public static class Egal extends ExpressionA_Binaire {
        public Egal(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
        public String symbole() {return "Egal";};
    }
    
    
    public static class SignatureEgal extends ExpressionA_Binaire {
        public ExpressionA exp1;
        public ExpressionA exp2;
        protected SignatureEgal(ExpressionA gauche, ExpressionA droite) {
            super(gauche,droite);
            this.exp1= gauche;
            this.exp2= droite;
            
        }
        @Override
        public String symbole() {
// TODO Auto-generated method stub
            return "SetVar";
        }
    }
    
    
    public static class Neg extends ExpressionA {
        public ExpressionA arg;
        
        public Neg(ExpressionA arg) {
            this.arg = arg;
        }
        public String toString() {
            return String.format("neg %1$s", arg.toString());
        }
        
    }
    
    public static class Pos extends ExpressionA {
        public ExpressionA arg;
        
        public Pos(ExpressionA arg) {
            this.arg = arg;
        }
        public String toString() {
            return String.format("pos %1$s", arg.toString());
        }
        
    }
    
    public static class Num extends ExpressionA {
        public int num;
        
        public Num(int num) {
            this.num = num;
        }
        public String toString() {
            return ("CstRe "+num);
        }
        
    }
    
    public static class Flo extends ExpressionA {
        public float num;
        
        public Flo(float num) {
            this.num = num;
        }
        public String toString() {
            return ("CstRe " +num);
        }
        
    }
    public static class Bool extends ExpressionA {
        public boolean Bool;
        
        public Bool(boolean Bool) {
            this.Bool = Bool;
        }
        public String toString() {
            return Boolean.toString(Bool);
        }
        
    }
    
    public static class Ident extends ExpressionA {
        public String Ident;
        
        public Ident(String Ident) {
            this.Ident = Ident;
        }
        public String toString() {
            return Ident;
        }
        
    }
    
    
    
    
    
    
}