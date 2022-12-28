package com.example.springpaytm;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.paytm.pg.merchant.PaytmChecksum;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaytmController 
{
	@Autowired
	private PaytmDetails paytmDetails;
	@Autowired
	private Environment environment;
	
	@GetMapping("/")
  public String home()
  {
	  return "Home";
  }
	
	@PostMapping("/pgredirect")
	public ModelAndView pageRedirect(@RequestParam(name = "CUST_ID") String customerId,
			                   @RequestParam(name = "TAX_AMOUNT") String transactionAount,
			                   @RequestParam(name = "ORDER_ID") String orderId
			                   ) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView("redirect:" +paytmDetails.getPaytmUrl());
		TreeMap<String, String> parameters = new TreeMap<>();
		paytmDetails.getDetails().forEach((k,v) -> parameters.put(k, v));
		parameters.put("MOBILE_NO", environment.getProperty("paytm.mobile"));;
		parameters.put("EMAIL", environment.getProperty("paytm.email"));
		parameters.put("ORDER_ID", orderId);
		parameters.put("TXN_AMOUNT", transactionAount);
		parameters.put("CUST_ID", customerId);
		String checkSum = getCheckSum(parameters);
		parameters.put("CHECKSUMHASH", checkSum);
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception 
	{
		return PaytmChecksum.generateSignature(parameters, paytmDetails.getMerchantKey());
	}
	
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, org.springframework.ui.Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "report";
	    }
	 
	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	    	
	    	return PaytmChecksum.verifySignature(parameters, paytmDetails.getMerchantKey(), paytmChecksum);
	    }

}















