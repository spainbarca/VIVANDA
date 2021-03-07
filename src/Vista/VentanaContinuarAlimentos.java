
package Vista;
 import Modelo.*;
import Controlador.ControladorProductos;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
public class VentanaContinuarAlimentos extends JFrame {
    public DefaultComboBoxModel modeloCategoria, modeloProducto, modeloMarca;
    public ValidarNumero objeto = new ValidarNumero();
    public ValidarNumeroDecimal objeto2= new ValidarNumeroDecimal();
    public DefaultTableModel modelo=new DefaultTableModel();
    
    public JComboBox<String> ComboBoxCategoria;
    public JComboBox<String> ComboBoxMarca;
    public JComboBox<String> ComboBoxSubcategoria;
    public JButton btnAgregar;
    public JButton btnImagen;
    public JButton btnIrMenuPrincipal;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JLabel jLabel5;
    public JLabel jLabel6;
    public JLabel jLabel7;
    public JLabel jLabel8;
    public JLabel jLabel9;
    public JScrollPane jScrollPane1;
    public JTable jtbldatos;
    public JTextField txtCantidad;
    public JTextField txtCodigo;
    public JTextField txtDescripcion;
    public JTextField txtImagen;
    public JTextField txtPrecio;
    public JTextField txtNombre;
    public JLabel lblUser;
    public JComboBox ComboBoxUser;
    ProductosBean objProductosBean;
    ControladorProductos objControladorProductos;
    ProductosDAO objProductosDAO;

    public VentanaContinuarAlimentos() {
        
        initComponents();
        objControladorProductos=new ControladorProductos(this);
       // inicio=0;
       // fin=0;
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
        modelo.addColumn("CODIGO");
        modelo.addColumn("CATEGORÍA");
        modelo.addColumn("SUBCATEGORÍA");
        modelo.addColumn("MARCA");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECO x C/U   S/.");
        modelo.addColumn("PRECIO TOTAL S/.");
        modelo.addColumn("USUARIO");
        jtbldatos.setModel(modelo);
        cargarCategoria();
        
        objProductosDAO = new ProductosDAO(this);
    }
    public void limpiarCampos(){
        
        objProductosDAO.tablaDatos();
    }
  
    public final void cargarCategoria(){
        String Catego[]={"Seleccionar...","Aseo personal","Bebidas y licores","Carnes y pescados","Despensa","Electrohogar","Frutas y verduras",
           "Golosinas", "Lacteos","Limpieza domestica","Panaderia y pasteleria"};
        modeloCategoria =new DefaultComboBoxModel(Catego);
        ComboBoxCategoria.setModel(modeloCategoria);
    }
    
    public void cargarProducto(){
        String AseoPersonal[]={"Seleccionar...","Papel Higienico","Pasta Dental","Jabón","Enguaje Bucal","Toallas Higienicas","Shampoo"};
        String Bebidas[]={"Seleccionar...","Agua Mineral","Bebida Energética","Cerveza","Gaseosa","Jugos","Vino"};  
        String Carnes[]={"Seleccionar...","Atun","Bonito","Conservas","Hot - Dog","Jamonada","Mariscos","Pechuga","Trucha"};
        String Despensa[]={"Seleccionar...","Aceites","Arroz","Azúcar","Conserva Frutas","Fideos","Flan","Frijoles","Gelatina","Harina","Lentejitas","Pallares","Sal","Salsa"};
        String Electrodomesticos[]={"Seleccionar...","Aspiradora","Lavadora","Licuadora","Microondas","Refrigeradora","Tablet","Televisor"};
        String Frutas[]={"Seleccionar...","Aceituna","Almendra","Banana","Cacao","Calabaza","Chirimoya","Durazno","Granadilla","Lima","Lucuma","Maní",
                                        "Manzana","Maracuya","Melón","Naranja","Palta","Pera","Piña","Sandía","Tomate"};
        String Golosinas[]={"Seleccionar...","Caramelos","Cereales","Chocolates","Galletas","Snacks"};
        String Lacteos[]={"Seleccionar...","Dulces Lácteos","Helados","Leche","Mantequilla","Queso","Yogurt"};
        String Limpieza[]={"Seleccionar...","Accesorios","Ambientadores","Desinfectantes","Detergente","Limpiadores"};
        String Panaderia[]={"Seleccionar...","Panes","Pasteles","Turrones","Panetones","Dulces","Masas"};
        
        String categ=ComboBoxCategoria.getSelectedItem().toString();
        if(categ.equals("Frutas y verduras")){
            modeloProducto = new DefaultComboBoxModel(Frutas);
            ComboBoxSubcategoria.setModel(modeloProducto);
        } else if (categ.equals("Bebidas y licores")){
            modeloProducto = new DefaultComboBoxModel(Bebidas);
            ComboBoxSubcategoria.setModel(modeloProducto);
        } else if (categ.equals("Electrohogar")){
            modeloProducto = new DefaultComboBoxModel(Electrodomesticos);
            ComboBoxSubcategoria.setModel(modeloProducto);
        } else if(categ.equals("Limpieza domestica")){
            modeloProducto = new DefaultComboBoxModel(Limpieza);
            ComboBoxSubcategoria.setModel(modeloProducto);
        } else if(categ.equals("Golosinas")){
            modeloProducto = new DefaultComboBoxModel(Golosinas);
            ComboBoxSubcategoria.setModel(modeloProducto);
        }else if (categ.equals("Lacteos")){
            modeloProducto = new DefaultComboBoxModel(Lacteos);
            ComboBoxSubcategoria.setModel(modeloProducto);       
        } else if(categ.equals("Despensa")){
            modeloProducto = new DefaultComboBoxModel(Despensa);
            ComboBoxSubcategoria.setModel(modeloProducto);
        } else if (categ.equals("Carnes y pescados")){
            modeloProducto = new DefaultComboBoxModel(Carnes);
            ComboBoxSubcategoria.setModel(modeloProducto);
        }else if(categ.equals("Panaderia y pasteleria")){
            modeloProducto = new DefaultComboBoxModel(Panaderia);
            ComboBoxSubcategoria.setModel(modeloProducto);
        }else if (categ.equals("Aseo personal")){
            modeloProducto=new DefaultComboBoxModel(AseoPersonal);
            ComboBoxSubcategoria.setModel(modeloProducto);
        }
    }
    
    public void cargarMarca(){   
        
        //Aseo
        String marcaPapelHigienico[]={"Seleccionar...","Elite","Kleenex","Noble","Suave","Scott"};
        String marcaEnguajeBucal[]={"Seleccionar...","Colgate","Dento","Listerine","Oral-B"};
        String marcaJabon[]={"Seleccionar...","Bolivar","Johnson","Palmolive","Protex","Neko","Asepxia","Aval","Dove"};
        String marcaPastaDental[]={"Seleccionar...","Aquafresh","Colgate","Dento","Kolynos","Oral-B","Sensodyne"};
        String marcaToallaHigienica[]={"Seleccionar...","Always","Kotex","Ladysoft","Nosotras","Stayfree"};
        String marcaShampoo[]={"Seleccionar...","Ego","Elvive","Head & Shoulders","Johnson","Pantene","Sedal","Tresemme"};
        
        //Bebidas
        String marcaGaseosaa[]={"Seleccionar...","Coca Cola","Fanta","Inca Kola","KR","Pepsi","Sprite"};
        String marcaMineral[]={"Seleccionar...","Bezoya","Cielo","San Luis","San Mateo","Vida"};
        String marcaEnergettica[]={"Seleccionar...","Burn","Gatorade","Red Bull","Monster","Sporade"};
        String marcaCervezaa[]={"Seleccionar...","Pilsen","Cristal","Brahma","Cusqueña","Heineken"};
        String marcaVinoo[]={"Seleccionar...","Ridge","Graham's Port","Guigal","Torres","Concha y Toro"};
        String marcaJugoss[]={"Seleccionar...","Frugos","Pulp","Watts","Gloria","Cifrut","Tampico","Negrita","Cupri-Sun","Aruba"};
        
        //Carnes y Pescados
        String marcaAtun[]={"Seleccionar...","Marédoce","Pescanova"};
        String marcaBonito[]={"Seleccionar...","Marédoce","Pescanova"};
        String marcaHot[]={"Seleccionar...","Cerdeña","La Preferida","La Segoviana","Otto Kunz","San Fernando","Zaragoza"};
        String marcaTrucha[]={"Seleccionar...","Marédoce","Pescanova"};
        String marcaMariscos[]={"Seleccionar...","Marédoce","Pescanova"};
        String marcaJamonada[]={"Seleccionar...","Cerdeña","La Preferida","La Segoviana","Otto Kunz","San Fernando","Zaragoza"};
        String marcaPechuga[]={"Seleccionar...","Cerdeña","La Preferida","La Segoviana","Otto Kunz","San Fernando","Vivanda","Zaragoza"};
        String marcaConservas[]={"Seleccionar...","Florida","Primor","Real","Fanny","Campomar","Gloria"};
        String marcaHamburguesa[]={"Seleccionar...","Bachoco","Maheso","Plumrose","Sadia"};
        String marcaNuggest[]={"Seleccionar...","Bachoco","Maheso","Plumrose","Sadia"};
        
        //Despensa
        String marcaArroz[]={"Seleccionar...","Costeño","Exito","Paisana"};
        String marcaAzucar[]={"Seleccionar...","Bells","Cartavio"};
        String marcaLenteja[]={"Seleccionar...","Exito","La Asturiana","El Plebeyo"};
        String marcaPallar[]={"Seleccionar...","Costeño","Mass"};
        String marcaSal[]={"Seleccionar...","Cisne","Clipper","Emsal","Lebre"};
        String marcaHarina[]={"Seleccionar...","Blanca Flor","Molitalia","Nicolini","Sayon"};
        String marcaAceite[]={"Seleccionar...","Capri","Cil","Cocinero","Primor"};
        String marcaConserva[]={"Seleccionar...","Arica","Compass","Dos Caballos","Fanny"};
        String marcaFideo[]={"Seleccionar...","Don Vittorio","Lavaggi","Molitalia","Nicolini"};
        String marcaGelatina[]={"Seleccionar...","Negrita","Royal","Universal"};
        String marcaSalsa[]={"Seleccionar...","Alacena","Dolcetto","Herdez","Prego","???????"};
        String marcaFrijoles[]={"Seleccionar...","Costeño","El Duende","Florida","La Sierra","Schettino"};
        String marcaFlan[]={"Seleccionar...","Negrita","Royal","Universal"};
        
        //ElectroHogar
        String marcaMicroondass[]={"Seleccionar...","LG","Samsung","Oster","Panasonic","Electrolux","Recco","Daewoo"};
        String marcaLavadorass[]={"Seleccionar...","LG","Samsung","MABE","Panasonic","Electrolux","Indurama","Daewoo"};
        String marcaRefri[]={"Seleccionar...","LG","Samsung","Orange","Coldex","MABE","Indurama","Daewoo"};
        String marcaLicuadoraa[]={"Seleccionar...","Thomas","Taurus","Philips","Oster","Imaco","Práctika"};
        String marcaTelevisor[]={"Seleccionar...","LG","AOC","Panasonic","Philips","Samsung","Sony"};
        String marcaAspiradoraa[]={"Seleccionar...","Daewoo","Eletrolux","Imaco","Thomas","Karcher"};
        String marcaTablet[]={"Seleccionar...","Apple","Samsung","Microsoft","Huawei"};
        
        //Frutas y Verduras
        String marcaManzan[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaPeraa[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaSandiaa[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaMelonn[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaGranadillaa[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaNaranjaa[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaTomatee[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaPaltaa[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaAceituna[]={"Seleccionar...","Fragata","Jopa","La Masrojana"};
        String marcaAlmendra[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaBanana[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaCacao[]={"Seleccionar...","Drimer","Lindt","Pacari"};
        String marcaCalabaza[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaChirimoya[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaDurazno[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaLima[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaLucuma[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaMani[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaMaracuya[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        String marcaPiña[]={"Seleccionar...","BelPas","Kero Fruta","Perlin","Vivanda","Zespri"};
        
        //Golosinas
        String marcaChocolatess[]={"Seleccionar...","Sublime","Princesa","Winter","Vizzio","Snickers","Bon Bon","Donofrio"};
        String marcaGalletass[]={"Seleccionar...","Costa","Nabisco","Nestle","Winter","Victoria","Sayon","Picaras","Bell's","San Jorge"};
        String marcaCarameloss[]={"Seleccionar...","Ambrosoli","Arcor","Halls","Sayon"};
        String marcaSnackss[]={"Seleccionar...","Pringles","Frito Lay","Karinto","Inka Chips"};
        String marcaCerealess[]={"Seleccionar...","Angel","Nestlé","Fitness","Quaker","Costa","Bell's","3 ositos","Kellogg s"};
        
        //Lacteos
        String marcaMantequillaa[]={"Seleccionar...","Dorina","Manty","Sello de Oro","Gloria","Laive","La Danesa"};
        String marcaQuesoo[]={"Seleccionar...","Bonle","Laive"};
        String marcaYogurtt[]={"Seleccionar...","Gloria","Laive","Milkito","Tigo","Yoleit","Pura vida","Soy vida"};
        String marcaLechee[]={"Seleccionar...","Gloria","Ideal","Laive","Nestle","Pura Vida","Soy Vida"};
        String marcaDulcess[]={"Seleccionar...","Bonle","Gloria","Nestle","Casanto","Laserenisima","Milkaut","Sancor","Yoleit"};
        String marcaHeladoo[]={"Seleccionar...","Alacant","Artika","Donofrio","Haagen-Dazs","Nestle"};
        
        //Limpieza
        String marcaDetergentee[]={"Seleccionar...","Ace","Ariel","Opal","Bolivar","Marsella","Magia Blanca","Amor","Sapolio"};
        String marcaAmbientadoress[]={"Seleccionar...","Poett","Glade","Sapolio","Air Wick","Febreze"};
        String marcaDesinfectantess[]={"Seleccionar...","Boreal","CIF","Clorox","Harpic","Mr Musculo","Pato","Sapolio"};
        String marcaAccesorios[]={"Seleccionar...","Hude","Rey","Virutex"};
        String marcaLimpiadores[]={"Seleccionar...","Sapolio","Mr Musculo","Boreal","Pato", "CIF","Pinesol"};
        
        //Panadería
        String marcaPanes[]={"Seleccionar...","Bimbo","Vivanda"};
        String marcaPanetones[]={"Seleccionar...","Blanca Flor","Buon Natale","Donofrio","Gloria","Motta","San Jorge","Todinno","Winter"};
        String marcaTurrones[]={"Seleccionar...","Don Lucho","La Florencia","San Jose"};
        String marcaDulces[]={"Seleccionar...","Bauducco","Bimbo","La Florencia","Marinela","Saint Honore","Union"};
        String marcaMasas[]={"Seleccionar...","Bimbo","Masalista","Pizza Nostra","Ricolina"};
        String marcaPasteles[]={"Seleccionar...","Saint Honore","Vivanda"};
        
        
        
        String marc=ComboBoxSubcategoria.getSelectedItem().toString();
        
        //Frutas y Verduras
        if (marc.equals("Manzana")){
            modeloMarca = new DefaultComboBoxModel(marcaManzan);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Pera")){
            modeloMarca=new DefaultComboBoxModel(marcaPeraa);
            ComboBoxMarca.setModel(modeloMarca);
        } else if(marc.equals("Sandía")){
            modeloMarca=new DefaultComboBoxModel(marcaSandiaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Melón")){
            modeloMarca=new DefaultComboBoxModel(marcaMelonn);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Granadilla")){
            modeloMarca=new DefaultComboBoxModel(marcaGranadillaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Naranja")){
            modeloMarca=new DefaultComboBoxModel(marcaNaranjaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Tomate")){
            modeloMarca=new DefaultComboBoxModel(marcaTomatee);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Palta")){
            modeloMarca=new DefaultComboBoxModel(marcaPaltaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Aceituna")){
            modeloMarca=new DefaultComboBoxModel(marcaAceituna);
            ComboBoxMarca.setModel(modeloMarca);
        } else if(marc.equals("Almendra")){
            modeloMarca=new DefaultComboBoxModel(marcaAlmendra);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Banana")){
            modeloMarca=new DefaultComboBoxModel(marcaBanana);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Cacao")){
            modeloMarca=new DefaultComboBoxModel(marcaCacao);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Calabaza")){
            modeloMarca=new DefaultComboBoxModel(marcaCalabaza);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Chirimoya")){
            modeloMarca=new DefaultComboBoxModel(marcaChirimoya);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Durazno")){
            modeloMarca=new DefaultComboBoxModel(marcaDurazno);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Lima")){
            modeloMarca=new DefaultComboBoxModel(marcaLima);
            ComboBoxMarca.setModel(modeloMarca);
        } else if(marc.equals("Lucuma")){
            modeloMarca=new DefaultComboBoxModel(marcaLucuma);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Mani")){
            modeloMarca=new DefaultComboBoxModel(marcaMani);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Maracuya")){
            modeloMarca=new DefaultComboBoxModel(marcaMaracuya);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Piña")){
            modeloMarca=new DefaultComboBoxModel(marcaPiña);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Bebidas y Licores    
        }else if(marc.equals("Gaseosa")){
            modeloMarca=new DefaultComboBoxModel(marcaGaseosaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Agua Mineral")){
            modeloMarca=new DefaultComboBoxModel(marcaMineral);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Bebida Energética")){
            modeloMarca=new DefaultComboBoxModel(marcaEnergettica);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Cerveza")){
            modeloMarca=new DefaultComboBoxModel(marcaCervezaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Vino")){
            modeloMarca=new DefaultComboBoxModel(marcaVinoo);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Jugos")){
            modeloMarca=new DefaultComboBoxModel(marcaJugoss);
            ComboBoxMarca.setModel(modeloMarca);
            
        //ElectroHogar    
        }else if(marc.equals("Microondas")){
            modeloMarca=new DefaultComboBoxModel(marcaMicroondass);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Lavadora")){
            modeloMarca=new DefaultComboBoxModel(marcaLavadorass);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Refrigeradora")){
            modeloMarca=new DefaultComboBoxModel(marcaRefri);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Licuadora")){
            modeloMarca=new DefaultComboBoxModel(marcaLicuadoraa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Televisor")){
            modeloMarca=new DefaultComboBoxModel(marcaTelevisor);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Aspiradora")){
            modeloMarca=new DefaultComboBoxModel(marcaAspiradoraa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Tablet")){
            modeloMarca=new DefaultComboBoxModel(marcaTablet);
            ComboBoxMarca.setModel(modeloMarca);    
            
        //Limpieza     
        }else if(marc.equals("Detergente")){
            modeloMarca=new DefaultComboBoxModel(marcaDetergentee);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Ambientadores")){
            modeloMarca=new DefaultComboBoxModel(marcaAmbientadoress);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Desinfectantes")){
            modeloMarca=new DefaultComboBoxModel(marcaDesinfectantess);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Accesorios")){
            modeloMarca=new DefaultComboBoxModel(marcaAccesorios);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Limpiadores")){
            modeloMarca=new DefaultComboBoxModel(marcaLimpiadores);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Golosinas
        }else if(marc.equals("Chocolates")){
            modeloMarca=new DefaultComboBoxModel(marcaChocolatess);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Galletas")){
            modeloMarca=new DefaultComboBoxModel(marcaGalletass);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Caramelos")){
            modeloMarca=new DefaultComboBoxModel(marcaCarameloss);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Snacks")){
            modeloMarca=new DefaultComboBoxModel(marcaSnackss);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Cereales")){
            modeloMarca=new DefaultComboBoxModel(marcaCerealess);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Lacteos       
        }else if(marc.equals("Mantequilla")){
            modeloMarca=new DefaultComboBoxModel(marcaMantequillaa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Queso")){
                modeloMarca=new DefaultComboBoxModel(marcaQuesoo);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Yogurt")){
            modeloMarca=new DefaultComboBoxModel(marcaYogurtt);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Leche")){
            modeloMarca=new DefaultComboBoxModel(marcaLechee);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Dulces Lácteos")){
            modeloMarca=new DefaultComboBoxModel(marcaDulcess);
            ComboBoxMarca.setModel(modeloMarca);
        }else if(marc.equals("Helados")){
            modeloMarca=new DefaultComboBoxModel(marcaHeladoo);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Despensa    
        }else if(marc.equals("Arroz")){
            modeloMarca=new DefaultComboBoxModel(marcaArroz);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Azúcar")){
            modeloMarca = new DefaultComboBoxModel(marcaAzucar);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Lentejitas")){
            modeloMarca = new DefaultComboBoxModel(marcaLenteja);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Pallares")){
            modeloMarca = new DefaultComboBoxModel(marcaPallar);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Sal")){
            modeloMarca = new DefaultComboBoxModel(marcaSal);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Harina")){
            modeloMarca = new DefaultComboBoxModel(marcaHarina);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Aceites")){
            modeloMarca = new DefaultComboBoxModel(marcaAceite);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Conserva Fruta")){
            modeloMarca = new DefaultComboBoxModel(marcaConserva);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Fideos")){
            modeloMarca = new DefaultComboBoxModel(marcaFideo);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Gelatina")){
            modeloMarca = new DefaultComboBoxModel(marcaGelatina);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Salsa")){
            modeloMarca = new DefaultComboBoxModel(marcaSalsa);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Flan")){
            modeloMarca = new DefaultComboBoxModel(marcaFlan);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Frijoles")){
            modeloMarca = new DefaultComboBoxModel(marcaFrijoles);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Carnes y Pescados
        }else if (marc.equals("Atun")){
            modeloMarca = new DefaultComboBoxModel(marcaAtun);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Bonito")){
            modeloMarca = new DefaultComboBoxModel(marcaBonito);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Hot - Dog")){
            modeloMarca = new DefaultComboBoxModel(marcaHot);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Trucha")){
            modeloMarca = new DefaultComboBoxModel(marcaTrucha);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Mariscos")){
            modeloMarca = new DefaultComboBoxModel(marcaMariscos);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Jamonada")){
            modeloMarca = new DefaultComboBoxModel(marcaJamonada);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Pechuga")){
            modeloMarca = new DefaultComboBoxModel(marcaPechuga);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Conservas")){
            modeloMarca = new DefaultComboBoxModel(marcaConservas);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Nuggest")){
            modeloMarca = new DefaultComboBoxModel(marcaNuggest);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Hamburguesa")){
            modeloMarca = new DefaultComboBoxModel(marcaHamburguesa);
            ComboBoxMarca.setModel(modeloMarca);    
            
        //Panadería    
        }else if (marc.equals("Panes")){
            modeloMarca = new DefaultComboBoxModel(marcaPanes);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Panetones")){
            modeloMarca = new DefaultComboBoxModel(marcaPanetones);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Turrones")){
            modeloMarca = new DefaultComboBoxModel(marcaTurrones);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Dulces")){
            modeloMarca = new DefaultComboBoxModel(marcaDulces);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Pasteles")){
            modeloMarca = new DefaultComboBoxModel(marcaPasteles);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Masas")){
            modeloMarca = new DefaultComboBoxModel(marcaMasas);
            ComboBoxMarca.setModel(modeloMarca);
            
        //Aseo    
        }else if (marc.equals("Papel Higienico")){
            modeloMarca = new DefaultComboBoxModel(marcaPapelHigienico);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Pasta Dental")){
            modeloMarca = new DefaultComboBoxModel(marcaPastaDental);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Jabón")){
            modeloMarca = new DefaultComboBoxModel(marcaJabon);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Enguaje Bucal")){
            modeloMarca = new DefaultComboBoxModel(marcaEnguajeBucal);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Toallas Higienicas")){
            modeloMarca = new DefaultComboBoxModel(marcaToallaHigienica);
            ComboBoxMarca.setModel(modeloMarca);
        }else if (marc.equals("Shampoo")){
            modeloMarca = new DefaultComboBoxModel(marcaShampoo);
            ComboBoxMarca.setModel(modeloMarca);
        }
    }
    
   public void Guardar(){
       boolean estadoCampo;
       estadoCampo=objControladorProductos.ValidarCampos();
       objProductosBean=new ProductosBean();
       if (estadoCampo){
       objProductosBean.setCodigo(txtCodigo.getText());
       objProductosBean.setCategoria(ComboBoxCategoria.getSelectedItem().toString());
       objProductosBean.setSubcategoria(ComboBoxSubcategoria.getSelectedItem().toString());
       objProductosBean.setMarca(ComboBoxMarca.getSelectedItem().toString());
       objProductosBean.setDescripcion(txtDescripcion.getText());
       objProductosBean.setCantidad(Integer.parseInt(txtCantidad.getText()));
       objProductosBean.setPrecio(Double.parseDouble(txtPrecio.getText()));
       objProductosBean.setNombre(txtNombre.getText());
       objProductosBean.setPers_nombre(ComboBoxUser.getSelectedItem().toString());
       objControladorProductos.GrabarProductos(objProductosBean);
   }
   }

    private void initComponents() {

        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtCantidad = new JTextField();
        jLabel5 = new JLabel();
        txtPrecio = new JTextField();
        jLabel7 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtbldatos = new JTable();
        txtCodigo = new JTextField();
        ComboBoxCategoria = new JComboBox<>();
        btnAgregar = new JButton();
        btnIrMenuPrincipal = new JButton();
        jLabel8 = new JLabel();
        jLabel6 = new JLabel();
        jLabel9 = new JLabel();
        ComboBoxSubcategoria = new JComboBox<>();
        ComboBoxMarca = new JComboBox<>();
        txtDescripcion = new JTextField();
        btnImagen = new JButton();
        txtImagen = new JTextField();
        jLabel1 = new JLabel();
        txtNombre= new JTextField();
        lblUser = new JLabel();
        ComboBoxUser = new JComboBox();
        getContentPane().add(txtNombre);
        txtNombre.setBounds(1080, 292, 180, 28);
        txtNombre.setEditable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new Font("Tahoma", 1, 18)); 
        lblUser.setText("User:");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 35, 70, 30));
        
        ComboBoxUser.setFont(new Font("Tahoma", 1, 16)); 
        ComboBoxUser.addItem("noe");
        ComboBoxUser.addItem("dante");
        getContentPane().add(ComboBoxUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 35, 200, 30));
        
        jLabel2.setFont(new Font("Tahoma", 1, 18)); 
        jLabel2.setText("Codigo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 70, 30));

        jLabel3.setFont(new Font("Tahoma", 1, 18)); 
        jLabel3.setText("Categoría:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 110, 50));

        jLabel4.setFont(new Font("Tahoma", 1, 18)); 
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 100, 50));

        txtCantidad.setFont(new Font("Tahoma", 1, 14));
        txtCantidad.setSelectionColor(new java.awt.Color(204, 102, 0));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 200, 30));

        jLabel5.setFont(new Font("Tahoma", 1, 18)); 
        jLabel5.setText("Precio x c/u :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 140, 30));

        txtPrecio.setFont(new Font("Tahoma", 1, 14)); 
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 180, 30));

        jLabel7.setFont(new Font("Tahoma", 1, 18));
        jLabel7.setText("Subcategoría:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 140, 30));

        jtbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbldatos.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jtbldatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 1210, 300));

        txtCodigo.setFont(new Font("Tahoma", 1, 14)); 
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 180, 30));

        ComboBoxCategoria.setFont(new Font("Tahoma", 1, 14));
        ComboBoxCategoria.setToolTipText("");
        ComboBoxCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 180, 30));

        btnAgregar.setBackground(new Color(51, 102, 0));
        btnAgregar.setFont(new Font("Tahoma", 1, 18)); 
        btnAgregar.setForeground(new Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 170, 60));

        btnIrMenuPrincipal.setBackground(new Color(0, 51, 51));
        btnIrMenuPrincipal.setFont(new Font("Tahoma", 1, 14));
        btnIrMenuPrincipal.setForeground(new Color(255, 255, 255));
        btnIrMenuPrincipal.setText("Ir a Menu Principal");
        btnIrMenuPrincipal.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        btnIrMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnIrMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 60));

        jLabel8.setFont(new Font("Tahoma", 1, 36)); 
        jLabel8.setForeground(new Color(102, 102, 102));
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/iconos/collection.png"))); 
        jLabel8.setText("REGISTROS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 370, 110));

        jLabel6.setFont(new Font("Tahoma", 1, 18));
        jLabel6.setText("Descripción:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 130, 40));

        jLabel9.setFont(new Font("Tahoma", 1, 18)); 
        jLabel9.setText("Marca:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 70, 30));

        ComboBoxSubcategoria.setFont(new Font("Tahoma", 1, 14)); 
        ComboBoxSubcategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ComboBoxSubcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSubcategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxSubcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 200, 30));

        ComboBoxMarca.setFont(new Font("Tahoma", 1, 14)); 
        ComboBoxMarca.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(ComboBoxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, 180, 30));

        txtDescripcion.setFont(new Font("Tahoma", 1, 14)); 
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 200, 40));

        btnImagen.setFont(new Font("Tahoma", 1, 14)); 
        btnImagen.setText("Añadir Imagen:");
        btnImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagenMouseClicked(evt);
            }
        });
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        getContentPane().add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 150, 40));

        txtImagen.setFont(new Font("Tahoma", 1, 14)); 
        getContentPane().add(txtImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, 180, 40));
        txtImagen.setEditable(false);

        jLabel1.setFont(new Font("Tahoma", 1, 14)); 
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondoNaranja.png"))); 
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 650));

        pack();
    }

    private void txtCodigoActionPerformed(ActionEvent evt) {
    }

    private void btnIrMenuPrincipalActionPerformed(ActionEvent evt) {
       VentanaContinuar obj = new VentanaContinuar();
       obj.setVisible(true);
        this.dispose();
       
    }

    public void btnAgregarActionPerformed(ActionEvent evt) {
        
        Guardar();
    }

    private void ComboBoxCategoriaActionPerformed(ActionEvent evt) {
        cargarProducto();
    }

    private void ComboBoxSubcategoriaActionPerformed(ActionEvent evt) {
      cargarMarca();
    }

    private void btnImagenMouseClicked(MouseEvent evt) {
       objProductosDAO.ImagenNombre();
    }

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaContinuarAlimentos().setVisible(true);
            }
        });
    }
}
