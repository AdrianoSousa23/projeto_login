import java.util.Scanner;

class projeto {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    // -------------------------------------------Declaração de variáveis---
    String user, nomeCompleto, nomeFormatado, email, telefone, senha, telFormatado;
    int senhaForte, op;
    // ---------------------------------------------------------------------

    System.out.println("\nBem vindo!!\n\nInsira seu nome Completo.");
    nomeCompleto = ler.nextLine();

    clearScreen();

    nomeFormatado = nome(nomeCompleto);

    System.out.println("Insira um nome de usuário.\n");
    user = ler.next();

    clearScreen();

    System.out.println("Insira seu e-mail.");
    email = ler.next();

    clearScreen();

    System.out.println("Insira seu telefone.(Com DDD)");
    telefone = ler.next();

    clearScreen();

    telFormatado = formatTel(telefone);

    do {

      System.out.println(
          "Crie uma senha.\n\n A senha deve conter no mínimo (8) dígitos.\n(1) Letra Maiúscula\n(1) Letra Minúscula\n(1) Caractere especial\n(1) Número\n");
      senha = ler.next();

      senhaForte = vrfSenha(senha);

      if (senhaForte == 1) {
        clearScreen();

        do {
          System.out.println("Confirme os dados cadastrais:\n\n(1)Nome Completo: " + nomeCompleto
              + "\n(2)Nome de usuário: " + user + "\n(3)E-mail: " + email + "\n(4)Telefone: " + telFormatado
              + "\n(5)Senha: " + senha
              + "\n\n(Se desejar realizar alguma alteração no cadastro, digite o número correspondente a opção desejada e pressione enter.Se não, digite (0) para continuar.)");

          op = ler.nextInt();
          clearScreen();

          switch (op) {

            case 1:
              System.out.println("\nBem vindo!!\n\nInsira seu nome Completo.");
              
              ler = new Scanner(System.in);
              
              nomeCompleto = ler.nextLine();

              clearScreen();

              nomeFormatado = nome(nomeCompleto);

              break;

            case 2:
              System.out.println("Insira um nome de usuário.\n");
              user = ler.next();

              clearScreen();

              break;

            case 3:
              System.out.println("Insira seu e-mail.");
              email = ler.next();

              clearScreen();

              break;

            case 4:
              System.out.println("Insira seu telefone.(Com DDD)");
              telefone = ler.next();

              clearScreen();

              telFormatado = formatTel(telefone);

              break;

            case 5:
              do {
                System.out.println(
                    "Crie uma senha.\n\n A senha deve conter no mínimo (8) dígitos.\n(1) Letra Maiúscula\n(1) Letra Minúscula\n(1) Caractere especial\n(1) Número\n");
                senha = ler.next();

                senhaForte = vrfSenha(senha);

                if (senhaForte == 1) {
                  clearScreen();
                } else {
                  clearScreen();
                  System.out.println("Senha inválida!\n\n");
                }
              } while (senhaForte != 1);

              break;

            default:
              System.out.println("Opção inválida.");

              break;
          }
          if (op > 5 || op < 0) {
            clearScreen();
            System.out.println("Opção inválida.");
          } else if (op == 0) {
            clearScreen();
            System.out.println("Cadastro realizado com sucesso!");
          }
        } while (op > 0 && op <= 5 || op < 0 || op > 5);
      }

    } while (senhaForte != 1);

    //LOGIN-------------------------------------------------------------------------------------------------------

    int escolha;
    String acessoUser, acessoSenha;
    boolean confirmUser, confirmSenha;

    do {
    System.out.println("\n\nDeseja efetuar o login?\n\n(1) SIM\n(2). NÃO.");

    escolha = ler.nextInt();

    if (escolha == 1) {
      clearScreen();

      do {
      System.out.println("---LOGIN---");
      System.out.print("Digite o nome de usuário ou e-mail: ");
      
        acessoUser = ler.next();
      
        confirmUser = (acessoUser.equals(user) || acessoUser.equals(email));
      
      clearScreen();
      
      } while (confirmUser == false);

      clearScreen();
      
      do{
      System.out.println("---LOGIN---");
      System.out.print("\nDigite a senha: ");

       acessoSenha = ler.next();
       confirmSenha = (acessoSenha.equals(senha));
        
      clearScreen();
        
      } while (confirmSenha == false);

      System.out.println("Seja muito bem vindo, " + nomeFormatado + "!");
      
  } else if (escolha == 2) {
      
      clearScreen();

      System.out.println("Obrigado e volte sempre!");
      
    }
  } while (escolha < 1 && escolha > 2);

    
    
//----------------------------------------------------------------------------------------------------------------
  }

  public static void clearScreen() {
    System.out.print("\033\143");
    System.out.flush();
  }

  public static int vrfSenha(String senha) {

    // ----------------------------------------------------------
    int vrfMaiuscula = 0;
    int vrfMinuscula = 0;
    int vrfEspecial = 0;
    int vrfTamanho = senha.length();
    int vrfNumeros = 0;
    int vrf = 0;
    int rslt = 0;
    int cont = 0;
    // ----------------------------------------------------------

    for (cont = 0; cont < vrfTamanho; cont++) {

      vrf = senha.codePointAt(cont);

      if (vrf >= 65 && vrf <= 90) {
        vrfMaiuscula++;

      } else if (vrf >= 97 && vrf <= 122) {
        vrfMinuscula++;

      } else if (vrf >= 48 && vrf <= 57) {
        vrfNumeros++;

      } else if (vrf >= 32 && vrf <= 47 || vrf >= 58 && vrf <= 64 || vrf >= 91 && vrf <= 96
          || vrf >= 123 && vrf <= 126) {
        vrfEspecial++;
      }

    }

    if (vrfTamanho >= 8 && vrfMaiuscula > 0 && vrfMinuscula > 0 && vrfEspecial > 0 && vrfNumeros > 0) {
      rslt++;
    }

    return rslt;

  }

  public static String nome(String nomeCompleto) {

    String correcao = nomeCompleto.trim();
    int recorte = nomeCompleto.indexOf(' ');
    String format = nomeCompleto.substring(0, recorte);
    String formatFinal = format.trim();
    return formatFinal;
  }

  public static String formatTel(String telefone) {

    String pt1 = telefone.substring(2, 7);
    String pt2 = telefone.substring(7, 11);

    telefone = "(+55) " + '(' + telefone.charAt(0) + telefone.charAt(1) + ')' + pt1 + '-' + pt2;

    return telefone;

  }

}