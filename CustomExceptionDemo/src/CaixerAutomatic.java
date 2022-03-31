import excepcions.BalancNegatiu;
import excepcions.IngresDiari;
import excepcions.MassaDiners;
import model.CompteCorrent;
import utils.Utilities;

public class CaixerAutomatic {
    //attributes
    private static CompteCorrent acc;

    //methods
    public static void main(String[] args){
        System.out.println("BENVINGUT AL CAIXER AUTOMÀTIC...");
        acc = new CompteCorrent(100, 200);
        System.out.println("New account created. Current account balance is " + acc.getQuantitatDiners());
        menu();
    }

    private static void menu(){
        int opcio = Utilities.llegirInt("Quina acció vols realitzar:\n\t1.-Ingressar diners\n\t2.-Retirar diners\n\t3.-Revisar compte" +
                "\n\t4.-Canviar de dia\n\t5.-Sortir",1,5);
        switch (opcio){
            case 1:
                newDeposit(Utilities.llegirFloat("Escriu l'import a ingressar.",1,1000000000));
                menu();
                break;
            case 2:
                newWithdraw(Utilities.llegirFloat("Escriu l'import a treure.", 1, 1000000000));
                menu();
                break;
            case 3:
                System.out.println("Actualment tens " + consultarCompte() + "€.");
                menu();
                break;
            case 4:
                System.out.println("Has canviat de dia i el límit diari s'ha reiniciat.");
                canviarDia();
                menu();
                break;
            case 5:
                System.out.println("SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    private static void newDeposit(double c){
        try {
            acc.ingres(c);
            System.out.println("Has ingressat "+ c + "€ correctament. Avui has ingressat " + acc.getIngresDiari() + "€ de " + acc.getLimitDiari()
            + "€ diaris permesos.");
        }catch(MassaDiners md){
            System.out.println(md.getMessage());
        }catch(IngresDiari ie){
            System.out.println(ie.getMessage());
        }
        catch(Exception e){
            System.out.println("ERROR: Desconegut " + e);
        }
    }

    private static void newWithdraw(double c){
        try {
            acc.treureDiners(c);
            System.out.println("Withdraw of " + c + " registered. New account balance is " + acc.getQuantitatDiners());
        }catch(BalancNegatiu e){
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println("Something went wrong during withdraw operation.");
        }
    }

    private static double consultarCompte(){
        return acc.getQuantitatDiners();
    }

    private static void canviarDia(){
        acc.canviarDia();
    }
}
