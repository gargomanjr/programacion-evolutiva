/*
 * GUIPrincipalPE.java
 *
 * Created on 3 de marzo de 2010, 16:05
 */

package GUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.text.InternationalFormatter;

import org.math.plot.*;

import AG.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 *
 * @author  David
 */
public class GUIPrincipalPE extends javax.swing.JFrame {
	
	
	private AGFun1 ag1;
	private AGFun2 ag2;
	private AGFun3 ag3;
	private AGFun4 ag4;
	private AGFun5 ag5;

	private Funcion fun;
	private static final Logger log = Logger.getLogger("GUIPrincipalPE.class");
	

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


    /** Creates new form GUIPrincipalPE */
    public GUIPrincipalPE() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
		
    	
    	
    	jTabbedPane1	= new JTabbedPaneWithCloseIcon();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        
        jLabel_TamPob = new javax.swing.JLabel();
        InternationalFormatter formato_TamPob = new InternationalFormatter();
        formato_TamPob.setMaximum(new Integer(150));
        formato_TamPob.setMinimum(new Integer(2));
        jTextField_TamPob = new javax.swing.JFormattedTextField(formato_TamPob);
        
        jLabel_NumIter = new javax.swing.JLabel();
        InternationalFormatter formato_NumIter = new InternationalFormatter();
        formato_NumIter.setMaximum(new Integer(175));
        formato_NumIter.setMinimum(new Integer(1));
        jTextField_NumIter = new javax.swing.JFormattedTextField(formato_NumIter);
        
        jLabel_ProbCruce = new javax.swing.JLabel();
        InternationalFormatter formato_ProbCruce = new InternationalFormatter();
        formato_ProbCruce.setMaximum(new Double(100.0));
        formato_ProbCruce.setMinimum(new Double(1.0));
        jTextField_ProbCruce = new javax.swing.JFormattedTextField(formato_ProbCruce);
        
        jLabel__ProbMut = new javax.swing.JLabel();
        InternationalFormatter formato_ProbMut = new InternationalFormatter();
        formato_ProbMut.setMaximum(new Double(100.0));
        formato_ProbMut.setMinimum(new Double(0.0));
        jTextField_ProbMut = new javax.swing.JFormattedTextField(formato_ProbMut);
       
        jLabel_Tol = new javax.swing.JLabel();
        InternationalFormatter formato_Tol = new InternationalFormatter();
        formato_Tol.setMaximum(new Double(0.1));
        formato_Tol.setMinimum(new Double(0.00000001));
        jTextField_Tol = new javax.swing.JFormattedTextField(formato_Tol);
        
        
        jLabel_Nfun5 = new javax.swing.JLabel();
        InternationalFormatter formato_NumIter2 = new InternationalFormatter();
        formato_NumIter2.setMaximum(new Integer(8));
        formato_NumIter2.setMinimum(new Integer(1));
        jTextField_Nfun5 = new javax.swing.JFormattedTextField(formato_NumIter2);
        
        valoresPorDefecto();
       
        jButton_Ejecutar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_Resul = new javax.swing.JLabel();
        jButton_RepGrafica = new javax.swing.JButton();
        
        
        
         

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Funcion 1", "Funcion 2", "Funcion 3", "Funcion 4", "Funcion 5" }));

        jLabel_TamPob.setText("Tama�o Poblacion");

        jLabel_NumIter.setText("Numero Iteraciones");

        jLabel_ProbCruce.setText("Probabilidad de Cruce");

        jLabel__ProbMut.setText("Probabilidad de Mutacion");
        
        jLabel_Nfun5.setText("N func. 5");

        jLabel_Tol.setText("Tolerancia");

        jButton_Ejecutar.setText("Ejecutar");
        jButton_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					jButton_EjecutarActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel_Resul.setText("Resultado");

        jButton_RepGrafica.setText("Representacion Grafica");
        jButton_RepGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RepGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Tol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Tol, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel__ProbMut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ProbMut, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_ProbCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ProbCruce, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_NumIter, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_NumIter, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_TamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_TamPob, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel_Nfun5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jTextField_Nfun5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))   )
                .addGap(155, 155, 155))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Ejecutar)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Resul)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jButton_RepGrafica)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel_NumIter, jLabel_ProbCruce, jLabel_TamPob, jLabel_Tol, jLabel__ProbMut,jLabel_Nfun5, jTextField_NumIter, jTextField_ProbCruce, jTextField_ProbMut, jTextField_TamPob, jTextField_Tol,jTextField_Nfun5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_TamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_NumIter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_ProbCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel__ProbMut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Tol, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Nfun5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))                   
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_TamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_NumIter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ProbCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ProbMut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Tol, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)                        
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Nfun5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel_Resul)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Ejecutar)
                        .addGap(39, 39, 39)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_RepGrafica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel_NumIter, jLabel_ProbCruce, jLabel_TamPob, jLabel_Tol, jLabel__ProbMut, jTextField_NumIter, jTextField_ProbCruce, jTextField_ProbMut, jTextField_TamPob, jTextField_Tol ,jTextField_Nfun5});

        jTabbedPane1.addTab("Parametros", jPanel1);

       

        

        


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * @param evt
 * @throws IOException
 */
private void jButton_EjecutarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton_RepGraficaActionPerformed

			
			
			jTextArea1.setText("");
			
			//Seleccionamos la funcion a tratar
			switch(jComboBox1.getSelectedIndex())
			{
			case 0:	
						fun=Funcion.FUNCION_1;
						ag1 = new AGFun1((Integer) jTextField_TamPob.getValue(),
								(Integer) jTextField_NumIter.getValue(),
								(Double) jTextField_ProbCruce.getValue(),
								(Double) jTextField_ProbMut.getValue(),
								(Double) jTextField_Tol.getValue(), fun);
						ag1.ejecuta();
						jTextArea1.setText("F(x): "+ag1.getElMejor().getAptitud()+"\nX: "+ag1.getElMejor().getFenotipo()+"\n");
						break;
			case 1:
						fun = Funcion.FUNCION_2;
						ag2 = new AGFun2((Integer) jTextField_TamPob.getValue(),
								(Integer) jTextField_NumIter.getValue(),
								(Double) jTextField_ProbCruce.getValue(),
								(Double) jTextField_ProbMut.getValue(),
								(Double) jTextField_Tol.getValue(), fun);
						ag2.ejecuta();
						jTextArea1.setText("F(x,y): " + ag2.getElMejor().getAptitud() + "\nX: "
								+ ((CromosomaFuncion2) ag2.getElMejor()).getGenX()
								+ "\nY: "
								+ ((CromosomaFuncion2) ag2.getElMejor()).getGenY());
						break;
			case 2:
						fun=Funcion.FUNCION_3;
						ag3 = new AGFun3((Integer) jTextField_TamPob.getValue(),
								(Integer) jTextField_NumIter.getValue(),
								(Double) jTextField_ProbCruce.getValue(),
								(Double) jTextField_ProbMut.getValue(),
								(Double) jTextField_Tol.getValue(), fun);
						ag3.ejecuta();
						jTextArea1.setText("F(x): "+ag3.getElMejor().getAptitud() +"\nX: "+ag3.getElMejor().getFenotipo()+"\n");
						//jTextArea1.setText("F(x): "+ag3.getElMejor().evalua()+"\nX: "+ag3.getElMejor().getFenotipo()+"\n");
						break;
			case 3:
						fun = Funcion.FUNCION_4;
						ag4 = new AGFun4((Integer) jTextField_TamPob.getValue(),
								(Integer) jTextField_NumIter.getValue(),
								(Double) jTextField_ProbCruce.getValue(),
								(Double) jTextField_ProbMut.getValue(),
								(Double) jTextField_Tol.getValue(), fun);
						ag4.ejecuta();
						jTextArea1.setText("F(x1,x2): " + ag4.getElMejor().getAptitud() + "\nX1: "
								+ ((CromosomaFuncion4) ag4.getElMejor()).getGenX1()
								+ "\nX2: "
								+ ((CromosomaFuncion4) ag4.getElMejor()).getGenX2());
						break;
			default:
						fun=Funcion.FUNCION_5;
						ag5 = new AGFun5((Integer) jTextField_TamPob.getValue(),
								(Integer) jTextField_NumIter.getValue(),
								(Double) jTextField_ProbCruce.getValue(),
								(Double) jTextField_ProbMut.getValue(),
								(Double) jTextField_Tol.getValue(), fun,
								(Integer)jTextField_Nfun5.getValue());
						ag5.ejecuta();
						double[] resul = new double[ag5.getn()];
						CromosomaFuncion5 elMejor_aux = new CromosomaFuncion5((CromosomaFuncion5) ag5.getElMejor());
						resul =  (double[]) elMejor_aux.fenotipo();
						String sl_fenotipos = "";
						for(int i=0;i< ag5.getn();i++){
							sl_fenotipos = sl_fenotipos +"X." + Integer.toString(i)+ " :"+  Double.toString(resul[i]) + "\n";				
						}
						jTextArea1.setText("F(x): "+ag5.getElMejor().getAptitud() +"\n"+ sl_fenotipos);
						
						break;
			}
			
			
			
			
    }

private void valoresPorDefecto()
{
	jTextField_TamPob.setValue(30);
	jTextField_NumIter.setValue(50);
	jTextField_ProbCruce.setValue(40.0);
	jTextField_ProbMut.setValue(1.0);
	jTextField_Tol.setValue(0.0001);
	jTextField_Nfun5.setValue(2);
}
    
private void jButton_RepGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RepGraficaActionPerformed

	
		int numComp= jTabbedPane1.getComponentCount();
		if(numComp>1)
		{
			for(int i=1; i<numComp;i++)
			{
				jTabbedPane1.remove(1);
				
			}
		}
		switch(fun)
		{
		case FUNCION_1:	
			pintaFun1Funcion();
			pintaFun1Aptitud();
			break;
		case FUNCION_2:
			pintaFun2Funcion();
			pintaFun2Aptitud();
			break;
		case FUNCION_3:			
			pintaFun3Funcion();
			pintaFun3Aptitud();
			break;
		case FUNCION_4:
			pintaFun4Funcion();
			pintaFun4Aptitud();
			break;
		default:
			pintaFun5Funcion();
			pintaFun5Aptitud();
			break;
		
		}
	
    
        
}//GEN-LAST:event_jButton_RepGraficaActionPerformed

    private void pintaFun4Funcion() {
    	//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag4.getListaElMejor().size()];
		double[] y= new double[ag4.getListaElMejor().size()];
		for(int i= 0; i< ag4.getListaElMejor().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag4.getListaElMejor().get(i); 
		}
		jPanel_Funcion.addLinePlot("Funcion", x,  y);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Funcion",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}

	private void pintaFun4Aptitud() {
		// Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
		Plot2DPanel jPanel_Funcion = new Plot2DPanel();
		double[] x = new double[ag4.getListaMedioAptitud().size()];
		double[] y = new double[ag4.getListaMedioAptitud().size()];
		double[] z = new double[ag4.getListaMaximoAptitud().size()];
		for (int i = 0; i < ag4.getListaMedioAptitud().size(); i++) {
			x[i] = i;
			y[i] = ag4.getListaMedioAptitud().get(i);
			z[i] = ag4.getListaMaximoAptitud().get(i);

		}
		jPanel_Funcion.addLinePlot("Aptitudes Media", x, y);
		jPanel_Funcion.addLinePlot("Aptitudes Maxima", x, z);
		jPanel_Funcion.addLegend("SOUTH");

		// add a line plot to the PlotPanel

		jTabbedPane1.addTab("Aptitudes Media y Maxima", jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}

	private void pintaFun1Funcion() {
	
    	//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag1.getListaElMejor().size()];
		double[] y= new double[ag1.getListaElMejor().size()];
		for(int i= 0; i< ag1.getListaElMejor().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag1.getListaElMejor().get(i); 
		}
		jPanel_Funcion.addLinePlot("Funcion", x,  y);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Funcion",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}
    
	private void pintaFun2Funcion() {
		// Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
		Plot2DPanel jPanel_Funcion = new Plot2DPanel();
		double[] x = new double[ag2.getListaElMejor().size()];
		double[] y = new double[ag2.getListaElMejor().size()];
		for (int i = 0; i < ag2.getListaElMejor().size(); i++) {
			x[i] = i;
			y[i] = ag2.getListaElMejor().get(i);
		}
		jPanel_Funcion.addLinePlot("Funcion", x, y);
		jPanel_Funcion.addLegend("SOUTH");

		// add a line plot to the PlotPanel

		jTabbedPane1.addTab("Funcion", jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel

		
	}

	private void pintaFun2Aptitud() {
		// Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
		Plot2DPanel jPanel_Funcion = new Plot2DPanel();
		double[] x = new double[ag2.getListaMedioAptitud().size()];
		double[] y = new double[ag2.getListaMedioAptitud().size()];
		double[] z = new double[ag2.getListaMaximoAptitud().size()];
		for (int i = 0; i < ag2.getListaMedioAptitud().size(); i++) {
			x[i] = i;
			y[i] = ag2.getListaMedioAptitud().get(i);
			z[i] = ag2.getListaMaximoAptitud().get(i);

		}
		jPanel_Funcion.addLinePlot("Aptitudes Media", x, y);
		jPanel_Funcion.addLinePlot("Aptitudes Maxima", x, z);
		jPanel_Funcion.addLegend("SOUTH");

		// add a line plot to the PlotPanel

		jTabbedPane1.addTab("Aptitudes Media y Maxima", jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
		
	}

	private void pintaFun1Aptitud() {
		
		//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag1.getListaMedioAptitud().size()];
		double[] y= new double[ag1.getListaMedioAptitud().size()];
		double[] z= new double[ag1.getListaMaximoAptitud().size()];
		for(int i= 0; i< ag1.getListaMedioAptitud().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag1.getListaMedioAptitud().get(i);
			z[i]	=  	ag1.getListaMaximoAptitud().get(i);
			
		}
		jPanel_Funcion.addLinePlot("Aptitudes Media", x,  y);
		jPanel_Funcion.addLinePlot("Aptitudes Maxima", x,  z);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Aptitudes Media y Maxima",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}
    private void pintaFun3Funcion() {
    	
    	//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag3.getListaElMejor().size()];
		double[] y= new double[ag3.getListaElMejor().size()];
		for(int i= 0; i< ag3.getListaElMejor().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag3.getListaElMejor().get(i); 
		}
		jPanel_Funcion.addLinePlot("Funcion", x,  y);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Funcion",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}

	private void pintaFun3Aptitud() {
		
		//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag3.getListaMedioAptitud().size()];
		double[] y= new double[ag3.getListaMedioAptitud().size()];
		double[] z= new double[ag3.getListaMaximoAptitud().size()];
		for(int i= 0; i< ag3.getListaMedioAptitud().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag3.getListaMedioAptitud().get(i);
			z[i]	=  	ag3.getListaMaximoAptitud().get(i);
			
		}
		jPanel_Funcion.addLinePlot("Aptitudes Media", x,  y);
		jPanel_Funcion.addLinePlot("Aptitudes Maxima", x,  z);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Aptitudes Media y Maxima",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}
private void pintaFun5Funcion() {
    	
    	//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag5.getListaElMejor().size()];
		double[] y= new double[ag5.getListaElMejor().size()];
		for(int i= 0; i< ag5.getListaElMejor().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag5.getListaElMejor().get(i); 
		}
		jPanel_Funcion.addLinePlot("Funcion", x,  y);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Funcion",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}

	private void pintaFun5Aptitud() {
		
		//Plot2DPanel jPanel_Aptitud = new Plot2DPanel();
	    Plot2DPanel  jPanel_Funcion = new Plot2DPanel();
		double[] x= new double[ag5.getListaMedioAptitud().size()];
		double[] y= new double[ag5.getListaMedioAptitud().size()];
		double[] z= new double[ag5.getListaMaximoAptitud().size()];
		for(int i= 0; i< ag5.getListaMedioAptitud().size();i++)
		{
			x[i]	=	i;
			y[i]	=	ag5.getListaMedioAptitud().get(i);
			z[i]	=  	ag5.getListaMaximoAptitud().get(i);
			
		}
		jPanel_Funcion.addLinePlot("Aptitudes Media", x,  y);
		jPanel_Funcion.addLinePlot("Aptitudes Maxima", x,  z);
		jPanel_Funcion.addLegend("SOUTH");
 
		// add a line plot to the PlotPanel
		
		jTabbedPane1.addTab("Aptitudes Media y Maxima",  jPanel_Funcion);
		// put the PlotPanel in a JFrame like a JPanel
	
}
	/**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipalPE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Ejecutar;
    private javax.swing.JButton jButton_RepGrafica;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel_NumIter;
    private javax.swing.JLabel jLabel_ProbCruce;
    private javax.swing.JLabel jLabel_Resul;
    private javax.swing.JLabel jLabel_TamPob;
    private javax.swing.JLabel jLabel_Tol;
    private javax.swing.JLabel jLabel__ProbMut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel_Nfun5;    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private JTabbedPaneWithCloseIcon jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFormattedTextField jTextField_NumIter;
    private javax.swing.JFormattedTextField jTextField_ProbCruce;
    private javax.swing.JFormattedTextField jTextField_ProbMut;
    private javax.swing.JFormattedTextField jTextField_TamPob;
    private javax.swing.JFormattedTextField jTextField_Tol;
    private javax.swing.JFormattedTextField jTextField_Nfun5;
    
    
    // End of variables declaration//GEN-END:variables
    
    
    
	

}
