/*
 *
 *    Copyright (c) 2020 Project CHIP Authors
 *    All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * @file QRCodeWidget.cpp
 *
 * This file describes the QRCodeWidget that displays a QRCode centered on the screen
 *
 */

#ifndef QRCODE_WIDGET_H
#define QRCODE_WIDGET_H

#include "Display.h"

#if CONFIG_HAVE_DISPLAY

class QRCodeWidget
{
public:
    color_t QRCodeColor;
    uint16_t VMargin;
    /**
     * @brief
     *  Initializes the QRCode by generating a CHIP SetupPayload
     *  and draws it onto the display
     */
    void Display();
    QRCodeWidget();
};

#endif // CONFIG_HAVE_DISPLAY

#endif // QRCODE_WIDGET_H
