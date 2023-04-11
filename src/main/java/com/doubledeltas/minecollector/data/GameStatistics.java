package com.doubledeltas.minecollector.data;

import org.bukkit.advancement.AdvancementDisplayType;

import java.util.Map;

public class GameStatistics {
    private float totalScore;

    private float collectionScore;
    private float stackScore;
    private float advScore;

    /**
     * 게임 데이터로부터 통계를 구합니다.
     * @param data 게임 데이터
     */
    public GameStatistics(GameData data) {
        Map<String, Integer> collectionMap = data.getCollectionMap();

        this.collectionScore = collectionMap.size();

        this.stackScore = 0.0F;
        for (String key: collectionMap.keySet()) {
            this.stackScore += (data.getLevel(key) - 1) * 0.1F;
        }

        this.advScore = data.getAdvCleared(AdvancementDisplayType.TASK) * getAdvWeight(AdvancementDisplayType.TASK)
                        + data.getAdvCleared(AdvancementDisplayType.GOAL) * getAdvWeight(AdvancementDisplayType.GOAL)
                        + data.getAdvCleared(AdvancementDisplayType.CHALLENGE) * getAdvWeight(AdvancementDisplayType.CHALLENGE);

        this.totalScore = collectionScore + stackScore + advScore;
    }

    /**
     * Map으로부터 게임 데이터 통계를 얻습니다.
     * @param map 불러올 Map
     */
    public GameStatistics(Map<String, Float> map) {
        this.collectionScore = map.get("collectionScore");
        this.stackScore = map.get("stackScore");
        this.advScore = map.get("advScore");
        this.totalScore = collectionScore + stackScore + advScore;
    }

    public float getTotalScore() { return totalScore; }
    public float getCollectionScore() { return collectionScore; }
    public float getStackScore() { return stackScore; }
    public float getAdvScore() { return advScore; }

    /**
     * 게임 데이터 통계를 수정할 수 없는 Map으로 만듭니다.
     * @return Map
     */
    public Map<String, Float> toMap() {
        return Map.of(
                "collectionScore", collectionScore,
                "stackScore", stackScore,
                "advScore", advScore,
                "totalScore", totalScore
        );
    }

    /**
     * 발전과제 타입 별 점수를 얻습니다.
     * @param type 발전과제 타입
     * @return
     */
    public static float getAdvWeight(AdvancementDisplayType type) {
        return switch (type) {
            case TASK -> 1.0F;
            case GOAL -> 2.0F;
            case CHALLENGE -> 3.0F;
        };
    }
}
