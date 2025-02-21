package com.DatNguyen.ImageGenerator.Service;

import com.cloudinary.Cloudinary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {ImageService.class, Cloudinary.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
class ImageServiceDiffblueTest {
    @Autowired
    private ImageService imageService;

    /**
     * Test {@link ImageService#generateImage(String)}.
     * <p>
     * Method under test: {@link ImageService#generateImage(String)}
     */
    @Test
    @DisplayName("Test generateImage(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testGenerateImage() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Not enough variable values available to expand 'spring.ai.stabilityai.base-url'
        //       at com.DatNguyen.ImageGenerator.Service.ImageService.generateImage(ImageService.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        imageService.generateImage("Prompt");
    }

    /**
     * Test {@link ImageService#convertImageToMultipart(byte[])}.
     * <p>
     * Method under test: {@link ImageService#convertImageToMultipart(byte[])}
     */
    @Test
    @DisplayName("Test convertImageToMultipart(byte[])")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testConvertImageToMultipart() throws UnsupportedEncodingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Not enough variable values available to expand 'spring.ai.stabilityai.base-url'
        //       at com.DatNguyen.ImageGenerator.Service.ImageService.convertImageToMultipart(ImageService.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        imageService.convertImageToMultipart("AXAXAXAX".getBytes("UTF-8"));
    }

    /**
     * Test {@link ImageService#upload(MultipartFile)}.
     * <p>
     * Method under test: {@link ImageService#upload(MultipartFile)}
     */
    @Test
    @DisplayName("Test upload(MultipartFile)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testUpload() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Must supply api_key
        //       at com.cloudinary.Cloudinary.signRequest(Cloudinary.java:211)
        //       at com.cloudinary.Uploader.signRequestParams(Uploader.java:546)
        //       at com.cloudinary.http44.UploaderStrategy.callApi(UploaderStrategy.java:73)
        //       at com.cloudinary.Uploader.callApi(Uploader.java:34)
        //       at com.cloudinary.Uploader.upload(Uploader.java:76)
        //       at com.cloudinary.Uploader.upload(Uploader.java:68)
        //       at com.DatNguyen.ImageGenerator.Service.ImageService.upload(ImageService.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        imageService.upload(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    }
}
