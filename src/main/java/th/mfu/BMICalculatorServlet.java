package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);
        //TODO: calculate bmi
        double bmi = weight/ (height*height);
            int roundBmi = (int) Math.round(bmi);
        //TODO: determine the built from BMI
        String built = BuiltType(roundBmi);
    
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", roundBmi);
        request.setAttribute("built", built);

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }
    String BuiltType(int roundBmi){
        String text = "";
        if (roundBmi<18.5){
         text="underweight"; 
        }
        else if(roundBmi>=18.5 && roundBmi<25){
            text="normal";
        }
        else if(roundBmi>=30 && roundBmi<35){
            text="obese";
        }
        else if(roundBmi>=35){
            text="extremely obese";
        }
        return text;
    }
    
}
