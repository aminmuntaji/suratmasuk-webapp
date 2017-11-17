/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.safari.suratmasukwebapp.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import lab.safari.suratmasukwebapp.entity.Suratmasuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lab.safari.suratmasukwebapp.repo.SuratmasukRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author user
 */
@Controller
public class AppController {
    
    @Autowired
    private SuratmasukRepo prsmRepo;
    

    @RequestMapping("/daftar-suratmasuk")
    public void getDaftarMahasiswa(Model model) {
        model.addAttribute("daftarSuratmasuk",prsmRepo.findAll());
    }

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("prsm") Suratmasuk prsm,
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("prsm") Suratmasuk prsm, BindingResult result) {

    	System.out.println("id : " + prsm.getId());
    	System.out.println("tanggal_surat : " + prsm.getTanggal_surat());
    	System.out.println("judul_buku : " + prsm.getJudul());
        System.out.println("kepada : " + prsm.getKepada());
    	prsmRepo.save(prsm);
    	return "redirect:daftar-suratmasuk";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
        @ModelAttribute("prsm") Suratmasuk suratmasuk, BindingResult
        binding) {
        Suratmasuk prsm = prsmRepo.findOne(id);
        suratmasuk.setId(prsm.getId());
        suratmasuk.setTanggal_surat(prsm.getTanggal_surat());
        suratmasuk.setJudul(prsm.getJudul());
        suratmasuk.setKepada(prsm.getKepada());
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(
        @ModelAttribute("prsm") Suratmasuk prsm,
        BindingResult binding) {
        prsmRepo.save(prsm);
        return "redirect:/daftar-suratmasuk";
    }
    
    @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        prsmRepo.delete(id);
        return "redirect:/daftar-suratmasuk";
    }
    
}
