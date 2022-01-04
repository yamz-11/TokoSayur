/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas.Java.Cemilan_20200140103;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wiratama
 */
@Controller
public class ProjectController {
    
    @RequestMapping("/input")
    //ResponseBody
    public String getHasil(HttpServletRequest data, Model get){
        
        String getNama = data.getParameter("namaSayur");
        int getHarga = Integer.parseInt(data.getParameter("harga"));
        int getJumlah = Integer.parseInt(data.getParameter("jumlah"));
        int getBayar = Integer.parseInt(data.getParameter("bayar"));
        
        
        int totalAwal = totalAwal(getHarga,getJumlah);
        int totalAkhir = totalAkhir(getHarga,getJumlah);
        int kembalian = kembalian(getBayar,totalAkhir);
        
        get.addAttribute("namaSayur", getNama);
        get.addAttribute("harga", getHarga);
        get.addAttribute("jumlah", getJumlah);
        get.addAttribute("bayar", getBayar);
        get.addAttribute("totalAwal", totalAwal);
        get.addAttribute("totalAkhir", totalAkhir);
        get.addAttribute("kembalian", kembalian);
        
        
        return "tabelview";
    }
    
    private int totalAwal(int harga, int jumlah){
        int total = harga * jumlah;
        return total;
    }
    
    private int totalAkhir(int harga, int jumlah){
        int hargaAkhir;
        int total = harga * jumlah;
        if (total < 16000){
            hargaAkhir = total - (total * 0);
        }
        else if (total > 16000){
            hargaAkhir = total - (total * 10 / 100);
        }
        else {
            hargaAkhir = total - (total * 15 / 100);
        }
        
        return hargaAkhir;
    }
    private int kembalian(int getBayar, int totalAkhir){
        int kembalian = getBayar - totalAkhir;
        return kembalian; 
    }
    //private int Diskon(int harga, int jumlah){
       // int diskon;
        //int total = harga * jumlah;
        //if (total > 16000){
            //diskon = 
    //}
}
