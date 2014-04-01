/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.bl.video.VideoResources;

public class Videos extends VideoResources {
   protected Videos() {
      super();
      
   }
   
   protected Videos _D_Videos() {
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_Videos", _t_fini_0);
      }
      
   }
   
   protected Videos _Videos() {
      try {
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_Videos", _t_init_0);
      }
      
   }
   
}
