/* Generated By:JavaCC: Do not edit this line. TP1.java */
import java.io.InputStream;

public class TP1 implements TP1Constants {
    public static void main(String[] args) {
        TP1 parseur;
        AST ast;
        try {
            parseur = new TP1(System.in);
            ast = parseur.mainNT();
            System.out.println(ast.toString());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

  static final public AST.ExpressionA mainNT() throws ParseException {
    AST.ExpressionA res;
    res = expression();
    jj_consume_token(EOL);
                              {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AST.ExpressionA expression() throws ParseException {
    /*  Déclaration des variables*/
    AST.ExpressionA res;
    AST.ExpressionA temp;
    /* la variable temporaire*/
        temp = terme();
                   res = temp;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
      case 10:
      case 11:
      case 12:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        jj_consume_token(9);
        temp = terme();
                             res = new AST.Egal(res, temp);
        break;
      case 10:
        jj_consume_token(10);
        temp = terme();
                           res = new AST.Plus(res, temp);
        break;
      case 11:
        jj_consume_token(11);
        temp = terme();
                           res = new AST.Moins(res, temp);
        break;
      case 12:
        jj_consume_token(12);
        temp = terme();
                             res = new AST.SignatureEgal(res, temp);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
       {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AST.ExpressionA terme() throws ParseException {
    AST.ExpressionA res;
    AST.ExpressionA temp;
    temp = facteur();
                      res = temp;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 13:
      case 14:
      case 15:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 13:
        jj_consume_token(13);
        temp = facteur();
                           res = new AST.Mult(res, temp);
        break;
      case 14:
        jj_consume_token(14);
        temp = facteur();
                            res = new AST.Div(res, temp);
        break;
      case 15:
        jj_consume_token(15);
        temp = facteur();
                            res = new AST.Mod(res, temp);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AST.ExpressionA facteur() throws ParseException {
    AST.ExpressionA res;
    AST.ExpressionA temp;
    Token token;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 16:
      jj_consume_token(16);
      temp = expression();
      jj_consume_token(17);
                                   {if (true) return temp;}
      break;
    case 11:
      jj_consume_token(11);
      temp = facteur();
                             {if (true) return new AST.Neg(temp);}
      break;
    case 10:
      jj_consume_token(10);
      temp = facteur();
                             {if (true) return new AST.Pos(temp);}
      break;
    case NOMBRE:
      token = jj_consume_token(NOMBRE);
                         {if (true) return new AST.Num(Integer.parseInt(token.image));}
      break;
    case FLOAT:
      token = jj_consume_token(FLOAT);
                        {if (true) return new AST.Flo(Float.parseFloat(token.image));}
      break;
    case BOOL:
      token = jj_consume_token(BOOL);
                       {if (true) return new AST.Bool(Boolean.parseBoolean(token.image));}
      break;
    case IDENT:
      token = jj_consume_token(IDENT);
                       {if (true) return new AST.Ident(token.image);}
   {if (true) return res;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public TP1TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1e00,0x1e00,0xe000,0xe000,0x10dd0,};
   }

  /** Constructor with InputStream. */
  public TP1(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TP1(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TP1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public TP1(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TP1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public TP1(TP1TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TP1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[18];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 18; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
