package com.bjpowernode.future;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArchiveSearchService
 *
 * @Author Cat
 */
public class ArchiveSearchService {

    public List<String> search(String target) {
        return Arrays.asList("神秘消失的玛雅人，为何这么超前？可能会颠覆你的认知",
                "宁波大学东海战略研究院：持续提高海洋安全维护能力",
                "为什么尸体会让人产生恐惧？这些科学常识你要知道",
                "研究显示恐龙时代或结束于春季",
                "动物界那些令人难以置信的眼睛特征，你知道几个？",
                "强势围观，这是令太阳也黯然失色的大爆发？!磁超耀斑");
    }

    public List<String> searchNull(String target) {
        return null;
    }
}