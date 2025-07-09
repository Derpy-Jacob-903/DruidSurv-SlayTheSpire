package druidsurv.cards.colorless;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.oldBloons.fivedelaybloon;
import druidsurv.util.modifedclasses.mySetPortraitTextures2;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class VoidMonkey extends AbstractEasyCard {
    public final static String ID = makeID("VoidMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public VoidMonkey() {
        super(ID, 0, CardType.STATUS, CardRarity.CURSE, CardTarget.SELF, CardColor.CURSE, "NoArt");
        baseDamage = 200;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        this.exhaust = true;
        mySetPortraitTextures2 v = new mySetPortraitTextures2();
        v.mySetPortraitTextures(this, "druidsurvResources/images/cardui/512/frame_skill_void.png", "druidsurvResources/images/cardui/1024/frame_skill_void.png", 0,0);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new fivedelaybloon(p, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    public void triggerWhenDrawn() {
        addToBot((AbstractGameAction)new LoseEnergyAction(1));
    }

    @Override
    public void upp() {
        upgradeDamage(-100);
    }
}