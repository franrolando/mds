package com.mdsbooking.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AwsService {

	private AmazonS3 s3;
	private static final String BUCKET_NAME = "mds-booking-bucket";
	private static final String PATH_SEPARATOR = "/";

	public AwsService() {
		s3 = AmazonS3ClientBuilder.standard().withCredentials(new EnvironmentVariableCredentialsProvider())
				.withRegion(Regions.US_EAST_1).build();
	}

	public void getImage(String id) {
		GetObjectRequest getOR = new GetObjectRequest(BUCKET_NAME, id);
		s3.getObject(getOR).getKey();
	}

	public void createFolder(String folderName) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest por = new PutObjectRequest(BUCKET_NAME, folderName, emptyContent, metadata);
		s3.putObject(por);
	}

	public String uploadImage(String userFolder, String houseFolder, String image, String filename) {
		byte[] bI = Base64.decodeBase64((image.substring(image.indexOf(",") + 1)).getBytes());
		InputStream fis = new ByteArrayInputStream(bI);
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(bI.length);
		metadata.setContentType("image/png");
		metadata.setCacheControl("public, max-age=31536000");
		String objectKey = userFolder + PATH_SEPARATOR + houseFolder + PATH_SEPARATOR + filename;
		s3.putObject(BUCKET_NAME, objectKey, fis, metadata);
		s3.setObjectAcl(BUCKET_NAME, objectKey, CannedAccessControlList.PublicRead);
		URL objectUrl = s3.getUrl(BUCKET_NAME, objectKey);
		String path = objectUrl.getProtocol() + "://" + objectUrl.getAuthority() + objectUrl.getPath();
		return path;
	}

}
