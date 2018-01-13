/*
 * Copyright 2018 The Android YOLOv2 sample application Authors.
 *
 *     This file is part of Android YOLOv2 sample application.
 * Android YOLOv2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Android YOLOv2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Android YOLOv2. If not, see <http://www.gnu.org/licenses/>.
 */
package org.tensorflow.demo.util;

import android.content.res.AssetManager;

import org.tensorflow.demo.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * It is used to read names of the classes from the specified resource.
 *
 * Created by Zoltan Szabo on 12/17/17.
 * URL: https://github.com/szaza/android-yolov2
 */

public final class LabelProvider {
    public static Vector<String> readLabels(final AssetManager assetManager) {
        Vector<String> labels = new Vector();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open(Config.LABEL_FILE)))) {
            br.lines().forEach((line) -> labels.add(line));
        } catch (IOException ex) {
            throw new RuntimeException("Problem reading label file!", ex);
        }

        return labels;
    }
}