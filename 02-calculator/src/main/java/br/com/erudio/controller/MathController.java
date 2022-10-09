package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;

@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String  numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String  numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/rqd/{number}", method=RequestMethod.GET)
	public Double rqd(@PathVariable("number") String  number) throws Exception{
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double rqd = Math.sqrt(convertToDouble(number));
		return rqd;
	}
	
	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");		
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
