package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.FanClubBuff;
import druidsurv.powers.WizardPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

public class SMFC extends AbstractEasyCard {
    public final static String ID = makeID("SMFC");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SMFC() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new FanClubBuff(p(), damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        dmgDart(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}