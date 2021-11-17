package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.SneakyThrows;
import service.ImageService;

@WebServlet("/images/*")
public class ImageServlet  extends HttpServlet{
	
	private final ImageService imageService = ImageService.getInstace();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI();
		String imagePath = requestUri.replace("/images", "");
		
		imageService.get(imagePath)
			.ifPresentOrElse(image -> {
				resp.setContentType("application/octet-stream");
				writeImage(image, resp);
			},() -> resp.setStatus(404));
	}
	@SneakyThrows
	private void writeImage(InputStream image, HttpServletResponse resp) {
		try(image; ServletOutputStream outputStream = resp.getOutputStream()) {
			 int currentByte;
			 while ((currentByte = image.read()) != -1) {
				 outputStream.write(currentByte);
			 }
		}
		
	}
}
