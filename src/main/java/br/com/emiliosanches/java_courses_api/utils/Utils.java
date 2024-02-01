package br.com.emiliosanches.java_courses_api.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {
  public static void mergeObjects(Object target, Object source) {
    String[] nullProps = Utils.getNullPropertyNames(source);
    BeanUtils.copyProperties(source, target, nullProps);
  }

  public static String[] getNullPropertyNames(Object obj) {
    var wrapper = new BeanWrapperImpl(obj);

    var properties = wrapper.getPropertyDescriptors();

    Set<String> nullProperties = new HashSet<>();

    for (var property : properties) {
      var val = wrapper.getPropertyValue(property.getName());

      if (val == null)
        nullProperties.add(property.getName());
    }

    return nullProperties.toArray(new String[] {});
  }
}
