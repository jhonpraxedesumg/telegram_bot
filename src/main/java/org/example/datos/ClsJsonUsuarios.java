package org.example.datos;

public class ClsJsonUsuarios {

        public String Usuario = "C:\\TMP\\file.3Usuarios";

        //graba en un archivo json un objeto de tipo arraylist
        public String convierteObjetoJson(ArrayList<mdUsuario> listaObjetos) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            //Pasa el objeto a un archivo y lo guarda
            mapper.writeValue(new File(Usuario), listaObjetos);
            //pasa el json a un string
            String jsonInString = mapper.writeValueAsString(listaObjetos);
            return jsonInString;
        }




        public void  ingreso(){

            Scanner salida = new Scanner(System.in);
            int num;
            ArrayList<mdUsuario> listaCarreras2  = new ArrayList<>();
            ClsJsonUsuario obj = new ClsJsonUsuario();


            System.out.println("BIENVENIDO A CREAR UN DOCUMENTO JSON CON USUARIOS");
            System.out.println("Digite el numero de usuarios que desea ingresar");
            num = salida.nextInt();


            for( int i=0; i < num;i++){
                Scanner ingreso = new Scanner(System.in);
                String dato;
                long numero ;
                int numerito;

                ArrayList<mdUsuario> listaCarreras  = new ArrayList<>();

                mdUsuario carrera1 = new mdUsuario();


                System.out.println("ingresse el id del Usuario");
                numero = ingreso.nextLong();
                carrera1.setId(numero);

                System.out.println("ingresse el nombre del Usuario");
                ingreso = new Scanner(System.in);                       //reiniciamos el Scanner
                dato = ingreso.nextLine();
                carrera1.setNombre(dato);

                System.out.println("ingrese su carrera");
                dato = ingreso.nextLine();
                carrera1.setCarrera(dato);

                System.out.println("ingrese su Telefono");
                numerito = ingreso.nextInt();
                carrera1.setTelefono(numerito);

                System.out.println("ingresse el Correo del Usuario");
                ingreso=new Scanner(System.in);
                dato = ingreso.nextLine();
                carrera1.setCorreo(dato);


                listaCarreras.add(carrera1);
                listaCarreras2.add(carrera1);

                try {
                    System.out.println(obj.convierteObjetoJson(listaCarreras));
                } catch (IOException ex) {
                    System.out.println("error;"+ ex.getMessage());
                }
                listaCarreras = new ArrayList<>();

            }
            System.out.println("Documento Json resultante");
            try {
                System.out.println(obj.convierteObjetoJson(listaCarreras2));
            } catch (IOException ex) {
                System.out.println("error;"+ ex.getMessage());
            }


        }


//        public static void main(String[] args) {
//
//
//            ClsJsonUsuario obj = new ClsJsonUsuario();
//            obj.ingreso();

//        ArrayList<mdUsuario> listaCarreras = new ArrayList<>();
//        ArrayList<mdUsuario> listaCarreras2 = new ArrayList<>();
//        mdUsuario carrera1 = new mdUsuario();
//        System.out.println("ingresse el nombre del Usuario");
//        dato = ingreso.nextLine();
//        carrera1.setNombre(dato);
//
//        System.out.println("ingrese su carrera");
//        dato = ingreso.nextLine();
//        carrera1.setCarrera(dato);
//        //carrera1.setMensaje("Hola");
//        listaCarreras.add(carrera1);
//
//        // Agrega más objetos mdBot a listaCarreras si es necesario
//        carrera1 = new mdUsuario();
//        System.out.println("ingresse el nombre del Usuario");
//        dato = ingreso.nextLine();
//        carrera1.setNombre(dato);
//
//        System.out.println("ingrese su carrera");
//        dato = ingreso.nextLine();
//        carrera1.setCarrera(dato);
//        //carrera1.setMensaje("Hola");
//        listaCarreras2.add(carrera1);
//


 //           try {
//       System.out.println(obj.convierteObjetoJson(listaCarreras));
//       System.out.println(obj.convierteObjetoJson(listaCarreras2));
//    } catch (IOException ex) {
//        System.out.println("error;"+ ex.getMessage());
//   }



            }

        }

}
