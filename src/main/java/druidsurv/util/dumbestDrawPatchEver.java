package druidsurv.util;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.powers.watcher.EndTurnDeathPower;
import druidsurv.util.dailymods.Improvised;

@SpirePatch(
        clz = AbstractPlayer.class,
        method = "draw",
        paramtypez = { int.class } // Specify the parameter types
)
public class dumbestDrawPatchEver {
    public static void Prefix(AbstractPlayer ___instance) {
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised.ID) || ModHelper.isModEnabled(Improvised.ID)) {
            if (___instance.drawPile.isEmpty()) {
                ___instance.discardPile.clear();
                ___instance.exhaustPile.clear();
                ___instance.addPower(new EndTurnDeathPower(___instance));
            }
        }
    }
    public static void Postfix(AbstractPlayer ___instance) {
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised.ID) || ModHelper.isModEnabled(Improvised.ID)) {
            if (___instance.drawPile.isEmpty()) {
                ___instance.discardPile.clear();
                ___instance.exhaustPile.clear();
                ___instance.addPower(new EndTurnDeathPower(___instance));
            }
        }
    }
}

