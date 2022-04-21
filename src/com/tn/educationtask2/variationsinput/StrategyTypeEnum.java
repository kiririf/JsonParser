package com.tn.educationtask2.variationsinput;

import com.tn.educationtask2.takesipfromanywhere.GetIpFromFile;
import com.tn.educationtask2.takesipfromanywhere.GetIpFromUrl;
import com.tn.educationtask2.takesipfromanywhere.GetIpStrategy;

import java.util.Optional;

public enum StrategyTypeEnum {
    FILE {
        @Override
        public GetIpStrategy usedStrategy() {
            return new GetIpFromFile();
        }
    },
    URL {
        @Override
        public GetIpStrategy usedStrategy() {
            return new GetIpFromUrl();
        }
    };

    public static Optional<StrategyTypeEnum> getValueByName(String inputType) {
        for (StrategyTypeEnum enumValue : values()) {
            if (enumValue.name().equalsIgnoreCase(inputType)) {
                return Optional.of(enumValue);
            }
        }
        return Optional.empty();
    }

    public abstract GetIpStrategy usedStrategy();
}
