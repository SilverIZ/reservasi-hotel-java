/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh102_229.controller;

import javax.swing.JOptionPane;
import rh102_229.model.modelRHTamu;
import rh102_229.view.viewRHTamu;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author acer
 */
public class controllerRHTamu {
    private modelRHTamu mrht;
    private viewRHTamu vrht;
      
    
    public controllerRHTamu(viewRHTamu vrht){
        this.vrht = vrht;
        
    }
    
    public void simpan(){
//        JOptionPane.showConfirmDialog(vtb, "berhasil");
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dob = sdf.format(vrht.getCheckInView().getDate());
        mrht = new modelRHTamu();
        mrht.setNamaPemesanModel(vrht.getNamaPemesanView().getText());
        mrht.setNikModel(vrht.getNikView().getText());
         mrht.setCheckInModel(dob);
         mrht.setLamaBookingModel(Integer.parseInt(vrht.getLamaBookingView().getText()));
         mrht.setJumlahKamarModel(Integer.parseInt(vrht.getJumlahKamarView().getText()));
        mrht.setJenisKamarModel(String.valueOf(vrht.getJenisKamarView().getSelectedItem()));
        mrht.setPaketMenuModel(String.valueOf(vrht.getPaketMenuView().getSelectedItem()));
         mrht.setFasilitasModel(vrht.getFasilitasView().getText());
          mrht.setHargaKamarModel(Integer.parseInt(vrht.getHargaKamarView().getText()));
         mrht.setTambahanModel(Integer.parseInt(vrht.getTambahanView().getText()));
          mrht.setTotalHargaModel(Integer.parseInt(vrht.getTotalHargaView().getText()));
       
         mrht.simpanDataRH();
    } 
      public void tipeKamar(){
        if( vrht.getNamaPemesanView().getText().equals("")|| vrht.getNikView().getText().equals("")||
            vrht.getJumlahKamarView().equals("") )
        {
           JOptionPane.showMessageDialog(null, "harap isi kolom terlebih dahulu");
           
        }
        else {
            
            vrht.getPanelView().setVisible(true);
            vrht.getjPanel1().setVisible(false);
            if (vrht.getJenisKamarView().getSelectedIndex()==0){
                regular();  
            } else if (vrht.getJenisKamarView().getSelectedIndex()==1){
                deluxe();
            } else if (vrht.getJenisKamarView().getSelectedIndex()==2){
                vip();
            }
            
            if (vrht.getPaketMenuView().getSelectedIndex()==0){
                vrht.getTambahanView().setText("85000");
            }
            else if (vrht.getPaketMenuView().getSelectedIndex()==1){
                vrht.getTambahanView().setText("90000");
            }
            else if (vrht.getPaketMenuView().getSelectedIndex()==2){
                vrht.getTambahanView().setText("120000");
            }
            
            hitungTotal();
        }
    }  
    public void regular(){
        vrht.getFasilitasView().setText("Double Bed + Bathroom + AC");
        vrht.getHargaKamarView().setText("500000");
    }
    
    public void deluxe(){
        vrht.getFasilitasView().setText("Double Bed + Bathroom + AC + TV + Internet");
        vrht.getHargaKamarView().setText("600000");
    }
    
     public void vip(){
        vrht.getFasilitasView().setText("City View + Double Bed + Bathroom + AC + TV + Internet");
        vrht.getHargaKamarView().setText("750000");
    }
     
    public void hitungTotal(){
    
       int total;
       int harga = Integer.parseInt(vrht.getHargaKamarView().getText());
       int jumlah = Integer.parseInt(vrht.getJumlahKamarView().getText());
       int tambah = Integer.parseInt(vrht.getTambahanView().getText());
       total = (harga * jumlah)+tambah;
       vrht.getTotalHargaView().setText(total+"");
        
    }
    
     public void bersihkan(){
        vrht.getNamaPemesanView().setText("");
        vrht.getNikView().setText("");
        vrht.getCheckInView().setDate(Calendar.getInstance().getTime());
        vrht.getLamaBookingView().setText("");
        vrht.getJumlahKamarView().setText("");
        vrht.getJenisKamarView().setSelectedIndex(0);
        vrht.getPaketMenuView().setSelectedIndex(0);
        vrht.getFasilitasView().setText("");
        vrht.getHargaKamarView().setText("");
        vrht.getHargaKamarView().setText("");
        vrht.getTambahanView().setText("");
        vrht.getTotalHargaView().setText("");
    }
    
    public void cetakPDF(){
        
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dob = sdf.format(vrht.getCheckInView().getDate());
       String na =  vrht.getNamaPemesanView().getText();
       String em = vrht.getNikView().getText();
       String ci =  dob;
       String lb = vrht.getLamaBookingView().getText() + " Hari";
       String jk =  vrht.getJumlahKamarView().getText() + " Kamar";
       String jek = (String.valueOf(vrht.getJenisKamarView().getSelectedItem()));
       String pm = String.valueOf(vrht.getPaketMenuView().getSelectedItem());
       String fs =  vrht.getFasilitasView().getText();
       String hk = "Rp." + vrht.getHargaKamarView().getText();
       String tb = "Rp."+vrht.getTambahanView().getText();
        String bt = "Rp."+vrht.getTotalHargaView().getText();
        Document document = new Document();
        
        
      try{
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\ReservasiHotel18102_18229\\tamu.pdf"));
         document.open();
         
   
         PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Phrase("Sunny GO Hotel Receipt"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("NIK");
        table.addCell(em);
        table.addCell("Nama");
            table.addCell(na);
        table.addCell("CheckIn");
          table.addCell(ci);
        table.addCell("Lama Booking");
         table.addCell(lb);
        table.addCell("Jumlah Kamar");
         table.addCell(jk);
        table.addCell("jenis kamar");
          table.addCell(jek);
        table.addCell("paket menu");
        table.addCell(pm);
        table.addCell("fasilitas");
          table.addCell(fs);
        table.addCell("harga kamar");
           table.addCell(hk);
        table.addCell("tambahan");
        table.addCell(tb);
        table.addCell("total");
       table.addCell(bt);
      
      
        
      
        document.add(table);
        JOptionPane.showMessageDialog(null, "Berhasil Dicetak di E://ReservasiHotel18102_18229");
         document.close();
         writer.close();
      }catch(DocumentException | FileNotFoundException e){
          System.out.println("Error: "+e);
      }
    }
    


}
