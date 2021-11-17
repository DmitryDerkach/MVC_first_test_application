package service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.PropertiesUtil;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {

	private static final ImageService INSTANSE = new ImageService();
	
	private final String basePath = PropertiesUtil.get("image.base.url");
	
	@SneakyThrows
	public void upload(String imagePath, InputStream imageContent) {
		Path imageFullPath = Path.of(basePath, imagePath);
		try (imageContent) {
			Files.createDirectories(imageFullPath.getParent());
			Files.write(imageFullPath, imageContent.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}
	}
	
	public static ImageService getInstace() {
		return INSTANSE;
	}
	@SneakyThrows
	public Optional<InputStream> get(String imagePath) {
		Path imageFullPath = Path.of(basePath, imagePath);
		return Files.exists(imageFullPath)
				? Optional.of(Files.newInputStream(imageFullPath))
				: Optional.empty();
	}
	
}
