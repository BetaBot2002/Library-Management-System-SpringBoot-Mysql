package com.lms.librarymanagementsystem.Handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lms.librarymanagementsystem.models.SoftCopy;

public class UniqueSoftCopyHandler {
    public static List<SoftCopy> filterSoftCopies(List<SoftCopy> softCopies) {
        List<SoftCopy> filteredList = new ArrayList<>();
        Set<String> sidSet = new HashSet<>();

        for (SoftCopy softCopy : softCopies) {
            String sid = softCopy.getSid();

            if (!sidSet.contains(sid)) {
                filteredList.add(softCopy);
                sidSet.add(sid);
            }
        }

        return filteredList;
    }
}
