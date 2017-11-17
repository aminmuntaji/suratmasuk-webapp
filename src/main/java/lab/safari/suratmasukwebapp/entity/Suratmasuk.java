/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.safari.suratmasukwebapp.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */


@Entity
public class Suratmasuk {

    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String tanggal_surat;

    @Column @Getter @Setter
    private String judul;

    @Column @Getter @Setter
    private String kepada;



}
