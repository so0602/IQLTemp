/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.ui.UIProject;

public class IQLTemp extends UIProject {
   public IQLTemp() {
      super("IQLTemp.1.0.0", 1396955398334L);
      
   }
   
   public Images Images;
   
   public SoundEffects SoundEffects;
   
   public Videos Videos;
   
   public Documents Documents;
   
   public void destroy() {
      try {
         _D_IQLTemp();
         this.Images = null;
         this.SoundEffects = null;
         this.Videos = null;
         this.Documents = null;
      } catch (Throwable _t_fini2_0) {
         throw new VScriptRuntimeException("destroy", _t_fini2_0);
      }
      
   }
   
   public void initialize() {
      try {
         _IQLTemp();
         _I_UIApplication();
      } catch (Throwable _t_init2_0) {
         throw new VScriptRuntimeException("initialize", _t_init2_0);
      }
      
   }
   
   protected IQLTemp _D_IQLTemp() {
      _D_UIApplication();
      
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_IQLTemp", _t_fini_0);
      }
      
   }
   
   public IQLTemp _IQLTemp() {
      _UIApplication();
      
      try {
         this.Images = new Images()._Images();
         this.SoundEffects = new SoundEffects()._SoundEffects();
         this.Videos = new Videos()._Videos();
         this.Documents = new Documents()._Documents();
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_IQLTemp", _t_init_0);
      }
      
   }
   
}
