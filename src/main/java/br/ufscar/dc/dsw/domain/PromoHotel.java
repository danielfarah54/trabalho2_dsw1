package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "PromoHotel")
public class PromoHotel extends AbstractEntity<Long>{
		
	@NotNull(message = "{NotBlank.promoHotel.preco}")
	@Column(nullable = false, unique=false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal preco;
	
	@NotBlank(message = "{NotBlank.promoHotel.iniciopromo}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.iniciopromo}")
	@Column(nullable=false, unique=false, length=10)
    private String iniciopromo;

	@NotBlank(message = "{NotBlank.promoHotel.fimpromo}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.fimpromo}")
	@Column(nullable=false, unique=false, length=10)
	private String fimpromo;
    
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "sitereserva_id")
    private SiteReserva sitereserva;

	public PromoHotel() {
    }

	public PromoHotel(BigDecimal preco, String iniciopromo, String fimpromo, Hotel hotel) {
		this.preco = preco;
	    this.iniciopromo = iniciopromo;
	    this.fimpromo = fimpromo;
	    this.hotel = hotel;
	    this.sitereserva = new SiteReserva();
	}
	
	public PromoHotel(BigDecimal preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
		this.preco = preco;
	    this.iniciopromo = iniciopromo;
	    this.fimpromo = fimpromo;
	    this.hotel = hotel;
	    this.sitereserva = sitereserva;
	}
	
	public PromoHotel(Long id, BigDecimal preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
	    this(preco, iniciopromo, fimpromo, hotel, sitereserva);
	}
	
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getIniciopromo() {
        return iniciopromo;
    }

    public void setIniciopromo(String iniciopromo) {
        this.iniciopromo = iniciopromo;
    }
    
    public String getFimpromo() {
        return fimpromo;
    }

    public void setFimpromo(String fimpromo) {
        this.fimpromo = fimpromo;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public SiteReserva getSitereserva() {
        return sitereserva;
    }

    public void setSitereserva(SiteReserva sitereserva) {
        this.sitereserva = sitereserva;
    }
}