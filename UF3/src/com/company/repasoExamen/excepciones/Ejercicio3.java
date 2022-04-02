package com.company.repasoExamen.excepciones;

import com.company.repasoExamen.excepciones.customExceptions.Checked;
import com.company.repasoExamen.excepciones.customExceptions.Unchecked;

import java.util.*;

public class Ejercicio3 {

    private static String[] users;
    private static int userLimitLength = 15;
    private static List<String> names = Arrays.asList("ANTONIO","JOSE","MANUEL","FRANCISCO","JUAN","DAVID","JOSE ANTONIO","JOSE LUIS","JAVIER","JESUS","FRANCISCO JAVIER","CARLOS","DANIEL","MIGUEL","RAFAEL","JOSE MANUEL","PEDRO","ALEJANDRO","ANGEL","MIGUEL ANGEL","JOSE MARIA","FERNANDO","LUIS","PABLO","SERGIO","JORGE","ALBERTO","JUAN CARLOS","JUAN JOSE","RAMON","ENRIQUE","DIEGO","JUAN ANTONIO","VICENTE","ALVARO","RAUL","ADRIAN","JOAQUIN","IVAN","ANDRES","OSCAR","RUBEN","JUAN MANUEL","SANTIAGO","EDUARDO","VICTOR","ROBERTO","JAIME","FRANCISCO JOSE","IGNACIO","ALFONSO","SALVADOR","RICARDO","MARIO","JORDI","EMILIO","MARCOS","JULIAN","JULIO","TOMAS","AGUSTIN","GUILLERMO","GABRIEL","JOSE MIGUEL","FELIX","JOSE RAMON","MOHAMED","GONZALO","JOAN","MARC","MARIANO","ISMAEL","DOMINGO","JOSEP","CRISTIAN","JUAN FRANCISCO","ALFREDO","NICOLAS","SEBASTIAN","JOSE CARLOS","FELIPE","SAMUEL","HUGO","MARTIN","CESAR","AITOR","JOSE ANGEL","JOSE IGNACIO","GREGORIO","VICTOR MANUEL","HECTOR","LUIS MIGUEL","JOSE FRANCISCO","JUAN LUIS","LORENZO","ALBERT","CRISTOBAL","ESTEBAN","XAVIER","EUGENIO","IKER","RODRIGO","ANTONIO JOSE","ALEX","ARTURO","BORJA","VALENTIN","JOSE JAVIER","JESUS MARIA","JUAN MIGUEL","JAUME","ANTONIO JESUS","GERMAN","LUCAS","FRANCISCO MANUEL","JONATHAN","PEDRO JOSE","JOSE VICENTE","ADOLFO","ISAAC","PAU","BENITO","MOHAMMED","MOISES","ISIDRO","JUAN RAMON","ABEL","JUAN PEDRO","AHMED","BERNARDO","ERNESTO","CHRISTIAN","GERARDO","AARON","MANUEL JESUS","SERGI","MIKEL","CARMELO","PASCUAL","IÑIGO","FEDERICO","ASIER","ANTONIO MANUEL","MIQUEL","JOEL","MARCELINO","FRANCESC","BARTOLOME","ISRAEL","ERIC","MATEO","JON","ELOY","JESUS MANUEL","JOSE ALBERTO","FERMIN","LUIS ALBERTO","GERARD","AURELIO","JUAN JESUS","OMAR","UNAI","JONATAN","BENJAMIN","ORIOL","PERE","LLUIS","JOSEP MARIA","EUSEBIO","IÑAKI","ANTONI","JACINTO","POL","PEDRO ANTONIO","DARIO","VICTORIANO","CARLES","ELIAS","CARLOS ALBERTO","ARNAU","JOSE ENRIQUE","MARCO ANTONIO","JERONIMO","ANGEL LUIS","JUAN PABLO","MATIAS","ROGER","JUAN IGNACIO","KEVIN","ISIDORO","TEODORO","DIONISIO","ADRIA","BRUNO","CANDIDO","FLORENCIO","FRANCISCO JESUS","BLAS","JUSTO","ROMAN","GUSTAVO","JOSE JUAN","SANTOS","JUAN BAUTISTA","MANUEL ANGEL","LUIS FERNANDO","ARMANDO","SAID","ALEXANDER","DAMIAN","GINES","ALONSO","LUIS MANUEL","EMILIANO","IZAN","GUILLEM","CARLOS JAVIER","ENRIC","FAUSTINO","PEDRO LUIS","SERAFIN","ION","XABIER","GORKA","ANDER","FERRAN","RACHID","JUAN MARIA","GHEORGHE","MARCO","JOSE JOAQUIN","VASILE","IOAN","LEONARDO","ABRAHAM","FIDEL","JOSE DAVID","EDUARD","MAXIMO","RAMIRO","SAUL","AMADOR","ROGELIO","MARTI","CLAUDIO","LUCIANO","JULIO CESAR","LUIS MARIA","LUIS ANTONIO","JOSE ANDRES","FRANCISCO ANTONIO","FLORENTINO","JESUS ANGEL","EMILIO JOSE","MODESTO","YOUSSEF","MARIA CARMEN","MARIA","CARMEN","JOSEFA","ISABEL","ANA MARIA","MARIA DOLORES","MARIA PILAR","MARIA TERESA","ANA","LAURA","FRANCISCA","ANTONIA","DOLORES","MARIA ANGELES","CRISTINA","MARTA","MARIA JOSE","MARIA ISABEL","PILAR","MARIA LUISA","LUCIA","CONCEPCION","ELENA","MERCEDES","MANUELA","ROSA MARIA","RAQUEL","SARA","MARIA JESUS","PAULA","JUANA","TERESA","ROSARIO","ENCARNACION","BEATRIZ","ROSA","NURIA","SILVIA","MONTSERRAT","JULIA","PATRICIA","IRENE","MONICA","ANDREA","ROCIO","ANGELA","MARIA MAR","MARGARITA","SONIA","SANDRA","SUSANA","ALICIA","YOLANDA","ALBA","MARIA JOSEFA","MARINA","NATALIA","MARIA ROSARIO","INMACULADA","ANGELES","ESTHER","MARIA MERCEDES","ANA ISABEL","EVA","VERONICA","AMPARO","NOELIA","MARIA ROSA","MARIA VICTORIA","MARIA CONCEPCION","CAROLINA","CLAUDIA","EVA MARIA","CATALINA","CONSUELO","VICTORIA","LORENA","ANA BELEN","MARIA ANTONIA","MARIA ELENA","MIRIAM","EMILIA","NEREA","LUISA","INES","MARIA NIEVES","GLORIA","LIDIA","CARLA","AURORA","ESPERANZA","JOSEFINA","SOFIA","MILAGROS","OLGA","CELIA","MARIA SOLEDAD","PURIFICACION","MARIA CRISTINA","VIRGINIA","MARIA LUZ","FATIMA","LOURDES","VANESA","ALEJANDRA","CLARA","ANNA","MAGDALENA","BEGOÑA","VICENTA","ASUNCION","MATILDE","ISABEL MARIA","MARIA BELEN","ELISA","ESTEFANIA","REMEDIOS","AINHOA","ARACELI","TRINIDAD","MARIA ASUNCION","MARIA PAZ","ELVIRA","MARIA BEGOÑA","SOLEDAD","NATIVIDAD","GEMA","BELEN","BLANCA","DANIELA","MARIA ESTHER","MARIA LOURDES","FELISA","ASCENSION","TAMARA","VANESSA","NIEVES","MARIA CRUZ","GEMMA","PALOMA","RAFAELA","REBECA","ALMUDENA","ADELA","ADRIANA","MARIA INMACULADA","MARIA AMPARO","AMALIA","RAMONA","NOEMI","MIREIA","MARIA EUGENIA","AMELIA","TANIA");
    private static List<String> surnames = Arrays.asList("GARCIA","GONZALEZ","RODRIGUEZ","FERNANDEZ","LOPEZ","MARTINEZ","SANCHEZ","PEREZ","GOMEZ","MARTIN","JIMENEZ","RUIZ","HERNANDEZ","DIAZ","MORENO","ALVAREZ","MUÑOZ","ROMERO","ALONSO","GUTIERREZ","NAVARRO","TORRES","DOMINGUEZ","VAZQUEZ","RAMOS","GIL","RAMIREZ","SERRANO","BLANCO","SUAREZ","MOLINA","MORALES","ORTEGA","DELGADO","CASTRO","ORTIZ","RUBIO","MARIN","SANZ","NUÑEZ","IGLESIAS","MEDINA","GARRIDO","SANTOS","CASTILLO","CORTES","LOZANO","GUERRERO","CANO","PRIETO","MENDEZ","CALVO","CRUZ","GALLEGO","VIDAL","LEON","HERRERA","MARQUEZ","PEÑA","CABRERA","FLORES","CAMPOS","VEGA","DIEZ","FUENTES","CARRASCO","CABALLERO","NIETO","REYES","AGUILAR","PASCUAL","HERRERO","SANTANA","LORENZO","HIDALGO","MONTERO","IBAÑEZ","GIMENEZ","FERRER","DURAN","VICENTE","BENITEZ","MORA","SANTIAGO","ARIAS","VARGAS","CARMONA","CRESPO","ROMAN","PASTOR","SOTO","SAEZ","VELASCO","SOLER","MOYA","ESTEBAN","PARRA","BRAVO","GALLARDO","ROJAS","PARDO","MERINO","FRANCO","ESPINOSA","IZQUIERDO","LARA","RIVAS","SILVA","RIVERA","CASADO","ARROYO","REDONDO","CAMACHO","REY","VERA","OTERO","LUQUE","GALAN","MONTES","RIOS","SIERRA","SEGURA","CARRILLO","MARCOS","MARTI","SORIANO","MENDOZA","ROBLES","BERNAL","VILA","VALERO","PALACIOS","EXPOSITO","BENITO","ANDRES","VARELA","PEREIRA","MACIAS","GUERRA","HEREDIA","BUENO","ROLDAN","MATEO","VILLAR","CONTRERAS","MIRANDA","GUILLEN","MATEOS","ESCUDERO","AGUILERA","MENENDEZ","CASAS","APARICIO","RIVERO","ESTEVEZ","BELTRAN","PADILLA","GRACIA","RICO","CALDERON");
    private static List<String> checkedUsers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);
        System.out.println("Wellcome to the users generador.");
        System.out.println("How many users do you need?");
        int quantity = entry.nextInt();

        users = generate(quantity);

        try{
            for (int i = 0; i < users.length ; i++) {
                if(checkUser(users[i],checkedUsers)){
                    checkedUsers.add(users[i]);
                }
            }
        }catch (Unchecked u){
            System.out.println("ERROR longitud --> " + u.getMessage());
        }catch (Checked c){
            System.out.println("ERROR duplicado --> " + c.getMessage());
        }catch (Exception e){
            System.out.println("ERROR genérico --> " + e.getMessage());
        }

        showUsers(checkedUsers);
    }

    private static String[] generate(int quantity) {

        String[]  usersnew  = new String[quantity];

        for (int j = 0; j < usersnew.length; j++) usersnew[j] = getName();

        return usersnew;
    }

    private static String getName() {
        Random rand = new Random();
        return String.format("%s %s %s", names.get(rand.nextInt(names.size())), surnames.get(rand.nextInt(surnames.size())), surnames.get(rand.nextInt(surnames.size())));
    }

    private static boolean checkUser(String user, List<String> checkedUsers) throws Checked, Unchecked {
        boolean validUser = true;
        if(user.length() > userLimitLength){
            validUser = false;
            throw new Unchecked("Usuario demasiado largo.");
        }
        else if(checkedUsers.size() > 1){
            for (int i = 0; i < checkedUsers.size(); i++) {
                if(checkedUsers.get(i).equals(user)){
                    validUser = false;
                    throw new Checked("Usuario ya existente.");
                }
            }
        }
        return validUser;
    }

    private static void showUsers(List<String> users){
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}
