package co.com.bancolombia.mscurrencytest.infrastructure.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

public class AssetDTO {


    public enum AssetType {
        @JsonProperty("FIAT") FIAT("FIAT"), @JsonProperty("CRYPTO") CRYPTO("CRYPTO");

        private final String value;

        AssetType(String value) {

            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum AssetStatus {
        @JsonProperty("ACTIVE") ACTIVE("ACTIVE"), @JsonProperty("INACTIVE") INACTIVE("INACTIVE");

        private final String value;

        AssetStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


    }


    @Data
    @Builder(toBuilder = true, builderClassName = "AssetRequestDTOBuilder")
    @JsonDeserialize(builder = AssetDTO.AssetRequestDTO.AssetRequestDTOBuilder.class)
    public static class AssetRequestDTO {
        private String symbol;
        private AssetStatus status;
        private AssetType type;

        @JsonPOJOBuilder(withPrefix = "")
        public static class AssetRequestDTOBuilder {

        }

    }

    @Value
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    public static class AssetResponseDTO {
        String id;
        String name;
        String symbol;
        String status;
        String type;
        String url;
    }

}