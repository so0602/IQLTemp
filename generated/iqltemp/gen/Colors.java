/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.ui.Color;

public class Colors extends com.antennasoftware.api.ui.Colors {
   protected Colors() {
      super();
      
   }
   
   public static Color CompanyNavBarBG = new Color(-13881811);
   
   protected Colors _D_Colors() {
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_Colors", _t_fini_0);
      }
      
   }
   
   protected Colors _Colors() {
      try {
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_Colors", _t_init_0);
      }
      
   }
   
}
