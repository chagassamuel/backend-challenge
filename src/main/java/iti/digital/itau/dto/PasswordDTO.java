package iti.digital.itau.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import iti.digital.itau.rule.view.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {

	@NotNull
	@ApiModelProperty(required = true)
	private String password;

	@JsonView(value = Views.PasswordValidation.class)
	private Boolean valid;

}
