package com.tn.educationtask2.variationsinput;

import com.tn.educationtask2.takesipfromanywhere.GetIpFromFile;
import com.tn.educationtask2.takesipfromanywhere.GetIpFromUrl;
import com.tn.educationtask2.takesipfromanywhere.GetIpStrategy;

public enum StrategyTypeEnum {
    FILE {
        @Override
        public GetIpStrategy chosenStrategy() {
            return new GetIpFromFile();
        }
    },
    URL {
        @Override
        public GetIpStrategy chosenStrategy() {
            return new GetIpFromUrl();
        }
    };

    public abstract GetIpStrategy chosenStrategy();
}
