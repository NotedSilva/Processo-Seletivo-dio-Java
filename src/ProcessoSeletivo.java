import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        imprimirSelecionados();
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"GABRIEL", "LETICIA", "GUSTAVO", "LUCAS", "OSCAR"};
        for (String candidato : candidatos) {
                entrandoEmContato(candidato);
        }

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice + 1) + " é o " + candidatos[indice]);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeuContato = false;

        do {
            atendeuContato = atender();
            continuarTentando = !atendeuContato;

            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }

        }while (continuarTentando && tentativasRealizadas <  3);

        if (atendeuContato) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " REALIZADA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
        }

    }

    static boolean atender() {
        return  new Random().nextInt(3)==1;
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Gabriel", "Leticia", "Gustavo", "Lucas", "Oscar", "Daniela", "Laura", "Camila", "Felipe", "Jorge", "Patricia"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
        static double valorPretendido() {
            return ThreadLocalRandom.current().nextDouble(1800,2200);
        }


    static void analisarCandidato (double salarioPretendido) {
        double salarioBase = 2000;

        if (salarioPretendido < 2000){
            System.out.println("LIGAR PARA O CANDIDATO!");
        } else if (salarioPretendido == 2000) {
            System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRAPROPOSTA!");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS!");
        }
    }
}
