package Vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Modelo.ConsultarAseo;
import Modelo.AseoDAO;
import java.awt.Color;
import Modelo.AseoBean;
import Modelo.RSButtonMetro;

public final class VentanaAseo extends JFrame implements ActionListener,MouseListener, KeyListener {
    public JComboBox<String> ComboBoxSub;
    public JLabel Fondo;
    public JLabel Imagen;
    public JTable TablaAseo;
    public JButton btnEliminar;
    public JButton btnModificar;
    public JButton btnVaciar;
    public JTextField filtroMarca;
    public JLabel jLabel1;
    public JPanel jPanel1;
    public JScrollPane jScrollPane1;
    public JSpinner jSpinner1;
    public JLabel lblCantidad;
    public JLabel lblCategoria;
    public JLabel lblCodigo;
    public JLabel lblDescripcion;
    public JLabel lblImagen;
    public JLabel lblMarca;
    public JLabel lblMarcaFiltro;
    public JLabel lblPrecio;
    public JLabel lblSub;
    public JLabel lblSubcategoria;
    public RSButtonMetro rSButtonMetro1;
    public JTextField txtCantidad;
    public JTextField txtCategoria;
    public JTextField txtCodigo;
    public JTextField txtDescripcion;
    public JTextField txtPrecio;
    public JTextField txtSubcategoria;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JToggleButton btnOnOff;
    public JLabel iconcat;
    
    
    public DefaultTableModel modelo=new DefaultTableModel();
    public final TableRowSorter trsFiltro;
    ConsultarAseo objConsultarAseo;
    AseoDAO objAseoDAO;
    AseoBean objAseoBean;
    ArrayList<AseoBean> lista;
    /**
     * Creates new form VentanaAseo
     */
    public VentanaAseo() {
        initComponents();
        this.setLocationRelativeTo(null);
        objConsultarAseo = new ConsultarAseo();
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
        modelo.addColumn("CODIGO");
        modelo.addColumn("CATEGORÍA");
        modelo.addColumn("SUBCATEGORÍA");
        modelo.addColumn("MARCA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO x C/U   S/.");
        modelo.addColumn("PRECIO TOTAL S/.");
        modelo.addColumn("NOMBRE");
        TablaAseo.setModel(modelo);
        
        Listar();
        txtFiltrado(filtroMarca);
        trsFiltro=new TableRowSorter(modelo);
        TablaAseo.setRowSorter(trsFiltro);
        
        objAseoDAO=new AseoDAO(this);
        
         Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/Aseo.png"));
        setIconImage(icon);
         setVisible(true);
         btnOnOff.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {
        try{
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jSpinner1 = new JSpinner();
        jPanel1 = new JPanel();
        lblSub = new JLabel();
        ComboBoxSub = new JComboBox<>();
        lblMarcaFiltro = new JLabel();
        jScrollPane1 = new JScrollPane();
        TablaAseo = new JTable();
        filtroMarca = new JTextField();
        lblCodigo = new JLabel();
        txtCodigo = new JTextField();
        lblCategoria = new JLabel();
        txtCategoria = new JTextField();
        lblSubcategoria = new JLabel();
        txtSubcategoria = new JTextField();
        lblDescripcion = new JLabel();
        rSButtonMetro1 = new RSButtonMetro();
        txtDescripcion = new JTextField();
        lblCantidad = new JLabel();
        txtCantidad = new JTextField();
        txtPrecio = new JTextField();
        lblPrecio = new JLabel();
        jLabel1 = new JLabel();
        Imagen = new JLabel();
        lblImagen = new JLabel();
        lblMarca = new JLabel();
        btnEliminar = new JButton();
        btnModificar = new JButton();
        btnVaciar = new JButton();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        iconcat = new JLabel();
        Fondo = new JLabel();
        btnOnOff = new JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        //jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(null);

        //lblSub.setBackground(new java.awt.Color(255, 255, 255));
        lblSub.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblSub.setText("Subcategoria:");
        lblSub.setOpaque(true);
        jPanel1.add(lblSub);
        lblSub.setBounds(20, 120, 125, 22);

       ComboBoxSub.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxSubItemStateChanged(evt);
            }
        });
        ComboBoxSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSubActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxSub);
        ComboBoxSub.setBounds(155, 120, 200, 22);

        lblMarcaFiltro.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblMarcaFiltro.setText("Marca:");
        lblMarcaFiltro.setOpaque(true);
        jPanel1.add(lblMarcaFiltro);
        lblMarcaFiltro.setBounds(400, 120, 65, 24);

        TablaAseo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(TablaAseo);
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(25, 151, 1008, 197);
        jPanel1.add(filtroMarca);
        filtroMarca.setBounds(470, 120, 150, 24);

        lblCodigo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblCodigo.setText("Código:");
        lblCodigo.setOpaque(true);
        jPanel1.add(lblCodigo);
        lblCodigo.setBounds(90, 366, 90, 22);

        txtCodigo.setEditable(false);
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(206, 369, 136, 20);

        lblCategoria.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblCategoria.setText("Categoria:");
        lblCategoria.setOpaque(true);
        jPanel1.add(lblCategoria);
        lblCategoria.setBounds(90, 418, 90, 18);

        txtCategoria.setEditable(false);
        jPanel1.add(txtCategoria);
        txtCategoria.setBounds(206, 418, 136, 20);

        lblSubcategoria.setFont(new java.awt.Font("Arial Black", 1, 13)); 
        lblSubcategoria.setText("Subcategoria:");
        lblSubcategoria.setOpaque(true);
        jPanel1.add(lblSubcategoria);
        lblSubcategoria.setBounds(90, 463, 114, 25);

        txtSubcategoria.setEditable(false);
        jPanel1.add(txtSubcategoria);
        txtSubcategoria.setBounds(206, 467, 136, 20);

        lblDescripcion.setFont(new java.awt.Font("Arial Black", 1, 14)); // 
        lblDescripcion.setText("Descripción:");
        lblDescripcion.setOpaque(true);
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(90, 506, 112, 22);

        rSButtonMetro1.setBackground(new java.awt.Color(51, 102, 255));
        rSButtonMetro1.setForeground(new java.awt.Color(51, 102, 255));
        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar_morado.png"))); // NOI18N
        rSButtonMetro1.setColorHover(new java.awt.Color(0, 255, 255));
        rSButtonMetro1.setColorNormal(new java.awt.Color(255, 255, 255));
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro1);
        rSButtonMetro1.setBounds(25, 12, 174, 68);
        jPanel1.add(txtDescripcion);
        txtDescripcion.setBounds(206, 508, 259, 20);

        lblCantidad.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblCantidad.setText("Cantidad:");
        lblCantidad.setOpaque(true);
        jPanel1.add(lblCantidad);
        lblCantidad.setBounds(433, 366, 89, 22);
        jPanel1.add(txtCantidad);
        txtCantidad.setBounds(564, 369, 136, 20);
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(564, 418, 136, 20);

        lblPrecio.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        //lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio c/u (S/.):");
        lblPrecio.setOpaque(true);
        jPanel1.add(lblPrecio);
        lblPrecio.setBounds(433, 415, 128, 22);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMAGEN DE MARCA AQUI");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),2,true));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(154, 546, 295, 128);

        Imagen.setBackground(new java.awt.Color(255, 255, 255));
        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setText("IMAGEN DE PRODUCTO AQUI");
        Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),4,true));
        Imagen.setOpaque(true);
        jPanel1.add(Imagen);
        Imagen.setBounds(775, 366, 255, 255);

        lblImagen.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        //lblImagen.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblImagen);
        lblImagen.setText("Imagen del Producto");
        lblImagen.setOpaque(true);
        lblImagen.setBounds(822, 640, 176, 22);

        lblMarca.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        //lblMarca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblMarca);
        lblMarca.setText("Marca");
        lblMarca.setOpaque(true);
        lblMarca.setBounds(470, 597, 60, 22);

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.setBounds(700, 120, 99, 23);

        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(815, 120, 100, 23);
        
        btnVaciar.setText("Vaciar");
        jPanel1.add(btnVaciar);
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        btnVaciar.setBounds(933, 120, 100, 23);
        
        
        
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                                           Aseo Personal");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(250, 30, 660, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Banner2.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(340, 0, 480, 110);
        
        iconcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aseoPersonal.png"))); // NOI18N
        jLabel2.add(iconcat);
        iconcat.setBounds(50, 23, 75, 75);
        
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAseo3.jpg"))); // NOI18N
        Fondo.setText("jLabel2");
        Fondo.setPreferredSize(new java.awt.Dimension(1097, 700));
        jPanel1.add(Fondo);
        Fondo.setBounds(0, 0, 1070, 700);
        
        btnOnOff.setBackground(Color.red);
        btnOnOff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOnOff.setForeground(new java.awt.Color(255, 255, 255));
        btnOnOff.setText("OFF");
        btnOnOff.setActionCommand("ON\nOFF");
        btnOnOff.setOpaque(true);
        btnOnOff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnOffActionPerformed(evt);
            }
        });
         jPanel1.add(btnOnOff);
        btnOnOff.setBounds(920, 50, 60, 30);
        
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1064, 696));
        pack();
        
                ComboBoxSub.addItem(" ");
                ComboBoxSub.addItem("Cepillo Dental");
                ComboBoxSub.addItem("Jabón");
                ComboBoxSub.addItem("Papel Higienico");
                ComboBoxSub.addItem("Pasta Dental");
                ComboBoxSub.addItem("Shampoo");
                ComboBoxSub.addItem("Toallas Higienicas");
        
                TablaAseo.addMouseListener(this);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }// </editor-fold>                        

    private void ComboBoxSubActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnEliminarActionPerformed(ActionEvent evt) {                                            
        borrarDato();
        LimpiarCampos();
            Listar();        // TODO add your handling code here:
    }
    
    private void rSButtonMetro1ActionPerformed(ActionEvent evt) {                                               
        VentanaCategoria objeto=new VentanaCategoria();
        objeto.setVisible(true);
        this.dispose();
    } 
    
    private void btnModificarActionPerformed(ActionEvent evt) {    
        actualizarDatos();
        LimpiarCampos();
            Listar();        // TODO add your handling code here:
    }
    
    private void btnVaciarActionPerformed(ActionEvent evt) {                                            
        vaciarDato();
        LimpiarCampos();
            Listar();        // TODO add your handling code here:
    }
    
    private void btnOnOffActionPerformed(ActionEvent evt) {  
        objAseoDAO.ONOFF();
    }        
    
    private void ComboBoxSubItemStateChanged(ItemEvent evt) {                                             
        String query = ComboBoxSub.getSelectedItem().toString();
        
        TableRowSorter<DefaultTableModel> tr=new  TableRowSorter<DefaultTableModel>(modelo);
        TablaAseo.setRowSorter(tr);
        
        if(query!=" "){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            TablaAseo.setRowSorter(tr);
        }
    }                                     

    public void txtFiltrado(JTextField filtroMarca){
        
        
        filtroMarca.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char car = e.getKeyChar();
                if (Character.isDigit(car)){
                    getToolkit().beep();
                    e.consume();
                }
                
                String filtro="(?i)"+ filtroMarca.getText();
                trsFiltro.setRowFilter(RowFilter.regexFilter(filtro, 3));
            }
        });
        
    }
    
    public void Listar(){
        try {
            objAseoDAO.Listar();
        }catch (Exception e){
        } 
    }
    
    public void borrarDato(){
        objAseoDAO.BorrarDato();
    }
    
    public void vaciarDato(){
        objAseoDAO.VaciarDato();
    }
    
    
    public void seleccionar(){
        try{
            objAseoDAO.Seleccionar();
        }catch (Exception e){}  
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
            seleccionar();
    }
    
    public void LimpiarCampos(){
        objAseoDAO.LimpiarCampos();
    }
    
    public void actualizarDatos(){
        objAseoDAO.ActualizarDatos();
    }
    
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
        } 
            new VentanaAseo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
