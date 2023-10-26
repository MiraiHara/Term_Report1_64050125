package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import Model.ProductsTable;
import java.util.List;
import Model.Products;
import Model.Products;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");
      Model.Products pd = null;
      synchronized (request) {
        pd = (Model.Products) _jspx_page_context.getAttribute("pd", PageContext.REQUEST_SCOPE);
        if (pd == null){
          pd = new Model.Products();
          _jspx_page_context.setAttribute("pd", pd, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
                
            List<Products> pdList = ProductsTable.findAllProducts();
            Iterator<Products> itr = pdList.iterator();
            /*list product*/
     
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <form name=\"index\" action=\"indexController\" method=\"POST\">\n");
      out.write("            <center>\n");
      out.write("            <h1>DVD Catalog</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>DVD Names</th>\n");
      out.write("                <th>Rate</th>\n");
      out.write("                <th>Year</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                while(itr.hasNext()) {
                    pd = itr.next();
                    /*check all product*/
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <input type='checkbox' name='selectedMovies' value=\"");
      out.print( Integer.toString(pd.getId()) );
      out.write("\"/> ");
      out.print( pd.getMovie() );
      out.write(" </td>\n");
      out.write("                <td>");
      out.print( pd.getRating() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( pd.getYearcreate() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( pd.getPrice() );
      out.write("</td>\n");
      out.write("                <td><input type='text' name='quantity' value='0' size='5'/></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                    }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <td><input type='submit' name='Submit' value='Add To Cart'></td>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
