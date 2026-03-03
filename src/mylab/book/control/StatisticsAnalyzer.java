package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.text.DecimalFormat;

public class StatisticsAnalyzer {
    public void printStatistics(Publication[] publications) {
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");

        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("1. 타입별 평균 가격:");
        for (String type : avgPrice.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrice.get(type).intValue()) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        for (String type : distribution.keySet()) {
            System.out.println("   - " + type + ": " + df.format(distribution.get(type)) + "%");
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + df.format(ratio2007) + "%");
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPrice = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrice.put(type, totalPrice.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> avg = new HashMap<>();
        for (String type : totalPrice.keySet()) {
            avg.put(type, totalPrice.get(type) / (double) count.get(type));
        }
        return avg;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> dist = new HashMap<>();
        int total = publications.length;
        for (String type : counts.keySet()) {
            dist.put(type, counts.get(type) * 100.0 / total);
        }
        return dist;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) count++;
        }
        return count * 100.0 / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }
}