/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public class StreetBuilder {
    
    public StreetBuilder(int V, int H) {
        int Vlanes = V;
        String VlanesSpc = "";
        int Hlanes = H;
        String HlanesSpc = "";
        
        for (int i = 0; i < Hlanes; i++) {
            HlanesSpc += "                              \n";
        }
        
        for (int i = 0; i < Vlanes; i++) {
            VlanesSpc += " ";
        }
        
        String HStreetSpace = "               ";
        String HStreetBord  = "---------------";
        String VStreetBord  = "|";
        String Intersect =
                  HStreetSpace + VStreetBord + VlanesSpc + VStreetBord + HStreetSpace + "\n"
                + HStreetBord + VlanesSpc + VlanesSpc + HStreetBord + "\n"
                + HlanesSpc
                + HStreetBord + VlanesSpc + VlanesSpc + HStreetBord + "\n"
                + HStreetSpace + VStreetBord + VlanesSpc + VStreetBord + HStreetSpace;
        
        System.out.println(Intersect);
    }
}
