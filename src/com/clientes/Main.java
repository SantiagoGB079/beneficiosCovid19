package com.clientes;

import com.clases.BeneficiosCovid19;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import static com.clases.Constantes.*;

public class Main {

    public static void main(String[] args) {

        String nomTipoA;
        float valorA;
        String nomTipoB;
        float valorB;
        String entrada;
        int tipoBeneficio;
        Scanner lee = new Scanner(System.in);
        List<BeneficiosCovid19> lista1 = new ArrayList<>();
        List<BeneficiosCovid19> lista2 = new ArrayList<>();
        BeneficiosCovid19 beneficiosCovid19;
        BeneficiosCovid19 beneficiosCovid191;
        Main main = new Main();

        int opc = 1;

        while (opc == 1) {

            System.out.println(MENU_BENEFICIOS);
            entrada = lee.next();
            while (!isNumeric(entrada)){
                System.out.println(MENU_BENEFICIOS);
                entrada = lee.next();
            }
            tipoBeneficio = Integer.valueOf(entrada);

            switch (tipoBeneficio) {

                case 1:
                    beneficiosCovid19 = new BeneficiosCovid19();
                    beneficiosCovid19.setId(main.getIdBeneficio());
                    System.out.println(TIPO_A);
                    nomTipoA = lee.next();
                    while (isText(nomTipoA)){
                        System.out.println("\n" + TIPO_A);
                        nomTipoA = lee.next();
                    }
                    beneficiosCovid19.setNombre(nomTipoA);
                    System.out.println(VALOR);
                    entrada = lee.next();
                    while(!isNumeric(entrada)){
                        System.out.println(VALOR);
                        entrada = lee.next();
                    }
                    valorA = Float.valueOf(entrada);
                    beneficiosCovid19.setValorSubsidio(valorA);
                    lista1.add(beneficiosCovid19);
                    break;
                case 2:
                    beneficiosCovid191 = new BeneficiosCovid19();
                    beneficiosCovid191.setId(main.getIdBeneficio());
                    System.out.println(TIPO_B);
                    nomTipoB = lee.next();
                    while (isText(nomTipoB)){
                        System.out.println("\n" +TIPO_A);
                        nomTipoB = lee.next();
                    }
                    beneficiosCovid191.setNombre(nomTipoB);
                    System.out.println(VALOR);
                    entrada = lee.next();
                    while(!isNumeric(entrada)){
                        System.out.println(VALOR);
                        entrada = lee.next();
                    }
                    valorB = Float.valueOf(entrada);
                    beneficiosCovid191.setValorSubsidio(valorB);
                    lista2.add(beneficiosCovid191);
                    break;
                default:
                    System.out.println(OPCION_NO_VALIDA);
            }
            System.out.println(CONTINUAR);
            entrada = lee.next();
            while (!isNumeric(entrada)){
                System.out.println(CONTINUAR);
                entrada = lee.next();
            }
            opc = Integer.valueOf(entrada);
            while (opc != 1 && opc != 2){
                System.out.println(OPCION_NO_VALIDA + "\n"+ CONTINUAR);
                entrada = lee.next();
                while(!isNumeric(entrada)){
                    System.out.println(OPCION_NO_VALIDA + "\n"+ CONTINUAR);
                    entrada = lee.next();
                }
                opc = Integer.valueOf(entrada);
            }
        }
        System.out.println(SALIENDO);
        System.out.println("\n"+BARRA+BENEFICIARIO_A + (ESPACIOS.substring(BENEFICIARIO_A.length())));
        System.out.println(LINEAS);
        for (int i=0; i < lista1.size(); i++){

            System.out.println(BARRA + ID + lista1.get(i).getId() + (ESPACIOS.substring(ID.length()+lista1.get(i).getId().length())) +
                    "\n"+BARRA+NOMBRE +lista1.get(i).getNombre()+ (ESPACIOS.substring(NOMBRE.length()+lista1.get(i).getNombre().length()))
                    +"\n"+BARRA+VALOR_SUBSIDIO+ lista1.get(i).getValorSubsidio()+ (ESPACIOS.substring(VALOR_SUBSIDIO.length()+
                    lista1.get(i).getValorSubsidio().toString().length()))+"\n"+LINEAS);
        }

        System.out.println("\n"+BARRA+BENEFICIARIO_B + (ESPACIOS.substring(BENEFICIARIO_B.length())));
        System.out.println(LINEAS);
        for (int j=0; j < lista2.size(); j++){

            System.out.println(BARRA + ID + lista2.get(j).getId() + (ESPACIOS.substring(ID.length()+lista2.get(j).getId().length())) +
                    "\n"+BARRA+NOMBRE +lista2.get(j).getNombre()+ (ESPACIOS.substring(NOMBRE.length()+lista2.get(j).getNombre().length()))
                    +"\n"+BARRA+VALOR_SUBSIDIO+ lista2.get(j).getValorSubsidio()+ (ESPACIOS.substring(VALOR_SUBSIDIO.length()+
                    lista2.get(j).getValorSubsidio().toString().length()))+"\n"+LINEAS);
        }

        System.out.println("\t"+VALOR_SUBSIDIO+ main.getMejorbeneficios(lista1,lista2));
        System.out.println(LINEA_RESULTADO);
    }

    public Float getMejorbeneficios(List<BeneficiosCovid19>lista1, List<BeneficiosCovid19>lista2){

        float mayorA = 0;
        float mayorB = 0;
        float mayorT = 0;
        int mayorPosA = 0;
        int mayorPosB = 0;

        if (!lista1.isEmpty() || !lista2.isEmpty()) {

            if (!lista1.isEmpty()) {
                for (int k = 0; k < lista1.size(); k++) {
                    if (lista1.get(k).getValorSubsidio() > mayorA) {
                        mayorA = lista1.get(k).getValorSubsidio();
                        mayorPosA = k;
                    }
                }
            }
            if (!lista2.isEmpty()) {
                for (int l = 0; l < lista2.size(); l++) {
                    if (lista2.get(l).getValorSubsidio() > mayorB) {
                        mayorB = lista2.get(l).getValorSubsidio();
                        mayorPosB = l;
                    }
                }
            }

            mayorT = Math.max(mayorA, mayorB);
            System.out.println("\n"+LINEA_RESULTADO);
            System.out.println(MAYOR_A + mayorA +
                    MAYOR_B + mayorB + MAYOR_SUBSIDIO);

            System.out.println(mayorT == mayorA
                    ? TAB + ID + lista1.get(mayorPosA).getId() + "\n" + TAB + NOMBRE + lista1.get(mayorPosA).getNombre()
                    : TAB + ID + lista2.get(mayorPosB).getId() + "\n" + TAB + NOMBRE + lista2.get(mayorPosB).getNombre());
        } else
            System.out.println("\n"+LINEA_RESULTADO+"\n"+INFORMACION);

        return Float.valueOf(mayorT);
    }

    private String getIdBeneficio(){
        Random random = new Random();
         Integer id = 1+random.nextInt((9999+1)-1);
        return String.valueOf(id);
    }

    public static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            System.out.println(VALIDACION);
            return false;
        }
    }

    public static boolean isText(String value) {
        try {
            Integer.parseInt(value);
            System.out.println(VALIDACION_NOMBRE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}