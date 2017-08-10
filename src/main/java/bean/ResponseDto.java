package bean;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
	List<Error> response;
}
