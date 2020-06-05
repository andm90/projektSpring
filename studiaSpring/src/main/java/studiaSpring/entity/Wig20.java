package studiaSpring.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "wig20")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Wig20 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NonNull
	@Column(name="data")
	private LocalDate data;
	
	@NonNull
	@Column(name="otwarcie")
	private double otwarcie;
	
	@NonNull
	@Column(name="najwyzszy")
	private double najwyzszy;
	
	@NonNull
	@Column(name="najnizszy")
	private double najnizszy;
	
	@NonNull
	@Column(name="zamkniecie")
	private double zamkniecie;
	
	@NonNull
	@Column(name="wolumen")
	private int wolumen;

}
