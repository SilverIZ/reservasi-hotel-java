/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh102_229.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rh102_229.db.koneksiDB;

/**
 *
 * @author acer
 */
public class modelRHTamu {
   koneksiDB koneksi = new koneksiDB();

    public int getIdPesananModel() {
        return idPesananModel;
    }

    public void setIdPesananModel(int idPesananModel) {
        this.idPesananModel = idPesananModel;
    }
                  
    private int idPesananModel;
    private String sql;
    private String namaPemesanModel;
    private String nikModel;
    private String checkInModel;
    private int lamaBookingModel;
    private int jumlahKamarModel;
    private String jenisKamarModel;
    private String paketMenuModel;
    private String fasilitasModel;
    private int hargaKamarModel;
    private int tambahanModel;
    private int totalHargaModel;
    
    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNamaPemesanModel() {
        return namaPemesanModel;
    }

    public void setNamaPemesanModel(String namaPemesanModel) {
        this.namaPemesanModel = namaPemesanModel;
    }

    public String getNikModel() {
        return nikModel;
    }

    public void setNikModel(String nikModel) {
        this.nikModel = nikModel;
    }

    public String getCheckInModel() {
        return checkInModel;
    }

    public void setCheckInModel(String checkInModel) {
        this.checkInModel = checkInModel;
    }

    public int getLamaBookingModel() {
        return lamaBookingModel;
    }

    public void setLamaBookingModel(int lamaBookingModel) {
        this.lamaBookingModel = lamaBookingModel;
    }

    public int getJumlahKamarModel() {
        return jumlahKamarModel;
    }

    public void setJumlahKamarModel(int jumlahKamarModel) {
        this.jumlahKamarModel = jumlahKamarModel;
    }

    public String getJenisKamarModel() {
        return jenisKamarModel;
    }

    public void setJenisKamarModel(String jenisKamarModel) {
        this.jenisKamarModel = jenisKamarModel;
    }

    public String getPaketMenuModel() {
        return paketMenuModel;
    }

    public void setPaketMenuModel(String paketMenuModel) {
        this.paketMenuModel = paketMenuModel;
    }

    public String getFasilitasModel() {
        return fasilitasModel;
    }

    public void setFasilitasModel(String fasilitasModel) {
        this.fasilitasModel = fasilitasModel;
    }

    public int getHargaKamarModel() {
        return hargaKamarModel;
    }

    public void setHargaKamarModel(int hargaKamarModel) {
        this.hargaKamarModel = hargaKamarModel;
    }

    public int getTambahanModel() {
        return tambahanModel;
    }

    public void setTambahanModel(int tambahanModel) {
        this.tambahanModel = tambahanModel;
    }

    public int getTotalHargaModel() {
        return totalHargaModel;
    }

    public void setTotalHargaModel(int totalHargaModel) {
        this.totalHargaModel = totalHargaModel;
    }
    
    
    public void simpanDataRH() {
        String sql = ("INSERT INTO reservasi (nama_pemesan, nik, checkin, lama_booking,"
                + "jumlah_kamar,jenis_kamar, paket_menu, fasilitas, harga_kamar, tambahan, total_harga)"
                + "VALUES ('" + getNamaPemesanModel()+ "','" + getNikModel() + "','" + 
                getCheckInModel() + "','" + getLamaBookingModel()+ "','" +  getJumlahKamarModel()+ 
                "','" + getJenisKamarModel() + "','" + 
                getPaketMenuModel() + "','" + getFasilitasModel() + "','" + getHargaKamarModel() + 
                "','" + getTambahanModel()+ "','" + getTotalHargaModel()+"')");
        
        
         try {
             PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
             eksekusi.execute();
             
             JOptionPane.showMessageDialog(null, "done");
         } catch (SQLException ex) {
             Logger.getLogger(modelRHTamu.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "fail"+ex);
         }
    }
 
    
}
