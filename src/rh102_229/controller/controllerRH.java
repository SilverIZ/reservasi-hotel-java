/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh102_229.controller;

import javax.swing.JOptionPane;
import rh102_229.model.modelRH;
import rh102_229.view.viewRH;

/**
 *
 * @author acer
 */
public class controllerRH {
    private modelRH mrh;
    private viewRH vrh;
      
    
    public controllerRH(viewRH vrht){
        this.vrh = vrht;
        
    }
    
    public void simpan(){
//        JOptionPane.showConfirmDialog(vtb, "berhasil");
        mrh = new modelRH();
        mrh.setNamaPemesanModel(vrh.getNamaPemesanView().getText());
        mrh.setNikModel(vrh.getNikView().getText());
         mrh.setCheckInModel(vrh.getCheckInView().getText());
         mrh.setLamaBookingModel(Integer.parseInt(vrh.getLamaBookingView().getText()));
         mrh.setJumlahKamarModel(Integer.parseInt(vrh.getJumlahKamarView().getText()));
        mrh.setJenisKamarModel(String.valueOf(vrh.getJenisKamarView().getSelectedItem()));
        mrh.setPaketMenuModel(String.valueOf(vrh.getPaketMenuView().getSelectedItem()));
         mrh.setFasilitasModel(vrh.getFasilitasView().getText());
          mrh.setHargaKamarModel(Integer.parseInt(vrh.getHargaKamarView().getText()));
         mrh.setTambahanModel(Integer.parseInt(vrh.getTambahanView().getText()));
          mrh.setTotalHargaModel(Integer.parseInt(vrh.getTotalHargaView().getText()));
       
         mrh.simpanDataRH();
    } 
      public void tipeKamar(){
        if( vrh.getNamaPemesanView().getText().equals("")|| vrh.getNikView().getText().equals("")||
            vrh.getCheckInView().getText().equals("") )
        {
           JOptionPane.showMessageDialog(null, "harap isi kolom terlebih dahulu");
           
        }
        else {
            
            vrh.getPanelView().setVisible(true);
            if (vrh.getJenisKamarView().getSelectedIndex()==0){
                regular();  
            } else if (vrh.getJenisKamarView().getSelectedIndex()==1){
                deluxe();
            } else if (vrh.getJenisKamarView().getSelectedIndex()==2){
                vip();
            }
            
            if (vrh.getPaketMenuView().getSelectedIndex()==0){
                vrh.getTambahanView().setText("85000");
            }
            else if (vrh.getPaketMenuView().getSelectedIndex()==1){
                vrh.getTambahanView().setText("90000");
            }
            else if (vrh.getPaketMenuView().getSelectedIndex()==2){
                vrh.getTambahanView().setText("120000");
            }
            
            hitungTotal();
        }
    }  
    public void regular(){
        vrh.getFasilitasView().setText("Double Bed + Bathroom + AC");
        vrh.getHargaKamarView().setText("500000");
    }
    
    public void deluxe(){
        vrh.getFasilitasView().setText("Double Bed + Bathroom + AC + TV + Internet");
        vrh.getHargaKamarView().setText("600000");
    }
    
     public void vip(){
        vrh.getFasilitasView().setText("City View + Double Bed + Bathroom + AC + TV + Internet");
        vrh.getHargaKamarView().setText("7500000");
    }
     
    public void hitungTotal(){
    
       int total;
       int harga = Integer.parseInt(vrh.getHargaKamarView().getText());
       int jumlah = Integer.parseInt(vrh.getJumlahKamarView().getText());
       int tambah = Integer.parseInt(vrh.getTambahanView().getText());
       total = (harga * jumlah)+tambah;
       vrh.getTotalHargaView().setText(total+"");
        
    }
    
     public void bersihkan(){
        vrh.getNamaPemesanView().setText("");
        vrh.getNikView().setText("");
        vrh.getCheckInView().setText("");
        vrh.getLamaBookingView().setText("");
        vrh.getJumlahKamarView().setText("");
        vrh.getJenisKamarView().setSelectedIndex(0);
        vrh.getPaketMenuView().setSelectedIndex(0);
        vrh.getFasilitasView().setText("");
        vrh.getHargaKamarView().setText("");
        vrh.getHargaKamarView().setText("");
        vrh.getTambahanView().setText("");
        vrh.getTotalHargaView().setText("");
    }
    
    public void btnControl(){
        vrh.getBtnSimpan().setEnabled(true);
        vrh.getBtnHapus().setEnabled(false);
        vrh.getBtnEdit().setEnabled(false);
        vrh.getBtnBatal().setEnabled(false);
        vrh.getBtnBersih().setEnabled(true);
        
    }
    
        public void btnControlReverse(){
        vrh.getBtnSimpan().setEnabled(false);
        vrh.getBtnHapus().setEnabled(true);
        vrh.getBtnEdit().setEnabled(true);
        vrh.getBtnBatal().setEnabled(true);
         vrh.getBtnBersih().setEnabled(false);
    }
    
   public void update(){
       mrh = new modelRH();
          mrh = new modelRH();
         mrh.setIdPesananModel(Integer.parseInt(vrh.getIdPesananView().getText()));
        mrh.setNamaPemesanModel(vrh.getNamaPemesanView().getText());
        mrh.setNikModel(vrh.getNikView().getText());
         mrh.setCheckInModel(vrh.getCheckInView().getText());
         mrh.setLamaBookingModel(Integer.parseInt(vrh.getLamaBookingView().getText()));
         mrh.setJumlahKamarModel(Integer.parseInt(vrh.getJumlahKamarView().getText()));
        mrh.setJenisKamarModel(String.valueOf(vrh.getJenisKamarView().getSelectedItem()));
        mrh.setPaketMenuModel(String.valueOf(vrh.getPaketMenuView().getSelectedItem()));
         mrh.setFasilitasModel(vrh.getFasilitasView().getText());
          mrh.setHargaKamarModel(Integer.parseInt(vrh.getHargaKamarView().getText()));
         mrh.setTambahanModel(Integer.parseInt(vrh.getTambahanView().getText()));
          mrh.setTotalHargaModel(Integer.parseInt(vrh.getTotalHargaView().getText()));
       mrh.updateDataRH();
       bersihkan();
       btnControl();
       
   }
   public void delete(){
       mrh = new modelRH();
        mrh.setIdPesananModel(Integer.parseInt(vrh.getIdPesananView().getText()));
       mrh.hapusDataRH();
       btnControl();
       
       
   }
    
    


}
