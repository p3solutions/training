package JavaCode;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;

import org.bouncycastle.crypto.params.Argon2Parameters;

import java.nio.charset.StandardCharsets;


import java.util.Base64;

public class Argon {
	public static String encrypt(String password) {
		byte[] salt = generateFixedSalt16Byte();
		String encryptionKeyArgon2id = base64Encoding(generateArgon2idMinimal(password, salt));
		return encryptionKeyArgon2id;
	}

	public static byte[] generateArgon2idMinimal(String password, byte[] salt) {
		int opsLimit = 2;
		int memLimit = 8192;
		int outputLength = 32;
		int parallelism = 1;
		Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
				.withVersion(Argon2Parameters.ARGON2_VERSION_13) // 19
				.withIterations(opsLimit).withMemoryAsKB(memLimit).withParallelism(parallelism).withSalt(salt);
		Argon2BytesGenerator gen = new Argon2BytesGenerator();
		gen.init(builder.build());
		byte[] result = new byte[outputLength];
		gen.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);
		return result;
	}

	public static byte[] generateArgon2idInteractive(String password, byte[] salt) {
		int opsLimit = 2;
		int memLimit = 66536;
		int outputLength = 32;
		int parallelism = 1;
		Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
				.withVersion(Argon2Parameters.ARGON2_VERSION_13) // 19
				.withIterations(opsLimit).withMemoryAsKB(memLimit).withParallelism(parallelism).withSalt(salt);
		Argon2BytesGenerator gen = new Argon2BytesGenerator();
		gen.init(builder.build());
		byte[] result = new byte[outputLength];
		gen.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);
		return result;
	}

	public static byte[] generateArgon2idModerate(String password, byte[] salt) {
		int opsLimit = 3;
		int memLimit = 262144;
		int outputLength = 32;
		int parallelism = 1;
		Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
				.withVersion(Argon2Parameters.ARGON2_VERSION_13) // 19
				.withIterations(opsLimit).withMemoryAsKB(memLimit).withParallelism(parallelism).withSalt(salt);
		Argon2BytesGenerator gen = new Argon2BytesGenerator();
		gen.init(builder.build());
		byte[] result = new byte[outputLength];
		gen.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);
		return result;
	}

	public static byte[] generateArgon2idSensitive(String password, byte[] salt) {
		int opsLimit = 4;
		int memLimit = 1048576;
		int outputLength = 32;
		int parallelism = 1;
		Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
				.withVersion(Argon2Parameters.ARGON2_VERSION_13) // 19
				.withIterations(opsLimit).withMemoryAsKB(memLimit).withParallelism(parallelism).withSalt(salt);
		Argon2BytesGenerator gen = new Argon2BytesGenerator();
		gen.init(builder.build());
		byte[] result = new byte[outputLength];
		gen.generateBytes(password.getBytes(StandardCharsets.UTF_8), result, 0, result.length);
		return result;
	}


	private static byte[] generateFixedSalt16Byte() {
		byte[] salt = new byte[16]; // 16 x0's
		return salt;
	}

	private static String base64Encoding(byte[] input) {
		return Base64.getEncoder().encodeToString(input);
	}

}
