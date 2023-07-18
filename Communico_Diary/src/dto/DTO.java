package dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DTO {

	private int num;
	private String task;
	private String manager;
	private Date dday;
}
