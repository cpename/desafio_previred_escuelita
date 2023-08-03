package com.cpena.previred.backend.apirest.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresas")
@NoArgsConstructor
@Getter
@Setter
public class Empresa implements Serializable{

	private static final long serialVersionUID = 6395640401966812691L;
	
	@Id
	@Column(name = "empresa_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empresa_id_seq")
	@SequenceGenerator(name = "empresa_id_seq", sequenceName = "empresa_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "rut_empresa", nullable = false, unique = true, length = 9)
	private Integer rut;
	
	@Column(name = "razon_social", length = 250)
	private String razonSocial;
	
	@Column(name = "fecha_inser", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Column(name = "fecha_modif")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@Column(name = "identificador", length = 50, unique = true, nullable = false)	
	private String identificadorEmpresa;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<Trabajador> trabajadores;

	@Override
	public int hashCode() {
		return Objects.hash(createAt, id, identificadorEmpresa, razonSocial, rut, trabajadores, updateAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(createAt, other.createAt) && Objects.equals(id, other.id)
				&& Objects.equals(identificadorEmpresa, other.identificadorEmpresa)
				&& Objects.equals(razonSocial, other.razonSocial) && Objects.equals(rut, other.rut)
				&& Objects.equals(trabajadores, other.trabajadores) && Objects.equals(updateAt, other.updateAt);
	}
	
	

}
