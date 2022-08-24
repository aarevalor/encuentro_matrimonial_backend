package com.encuentro.matrimonial.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

	private List<AddressList> addressList;
	private String input;

}
